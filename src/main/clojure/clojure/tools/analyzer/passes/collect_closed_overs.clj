;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.collect-closed-overs
  (:require [clojure.tools.analyzer :refer [h]]
            [clojure.tools.analyzer.ast :refer [update-children]]
            [clojure.tools.analyzer.env :as env]
            [clojure.tools.analyzer.passes.cleanup :refer [cleanup]]
            [clojure.tools.analyzer.passes.uniquify :refer [uniquify-locals]]))

(def ^:private ^:dynamic *collects*)

(declare collect-closed-overs*)

(defmulti -collect-closed-overs* :op :hierarchy h)

(defmethod -collect-closed-overs* :default [ast] ast)

;; seed letfn bindings
(defmethod -collect-closed-overs* :op/letfn
  [ast]
  (let [bindings (:bindings ast)]
    (doseq [{:keys [name]} bindings]
      (swap! *collects* #(update-in % [:locals] conj name)))
    ast))

(defmethod -collect-closed-overs* :op/binding
  [ast]
  (let [name (:name ast)]
    (if (= :field (:local ast))
      (swap! *collects* #(assoc-in % [:closed-overs name] (cleanup ast))) ;; special-case: put directly as closed-overs
      (swap! *collects* #(update-in % [:locals] conj name)))              ;; register the local as a frame-local locals
    ast))

(defmethod -collect-closed-overs* :op/local
  [ast]
  (let [name (:name ast)]
    (when-not ((:locals @*collects*) name)                                         ;; if the local is not in the frame-local locals
      (swap! *collects* #(assoc-in % [:closed-overs name] (cleanup ast)))) ;; then it's from the outer frame locals, thus a closed-over
    ast))

(defn -collect-closed-overs
  [ast]
  (-> (-collect-closed-overs* ast)
    (update-children collect-closed-overs*))) ;; recursively collect closed-overs in the children nodes

(defn collect-closed-overs*
  [{:keys [op] :as ast}]
  (let [collects @*collects*
        collect? (some #(isa? @h % op) (:where collects))]
    (if collect?
      (let [[ast {:keys [closed-overs locals]}]
            (binding [*collects* (atom (merge @*collects*
                                              {:closed-overs {} :locals #{}}))]
              [(update-children ast -collect-closed-overs) @*collects*])]
        (swap! *collects* #(update-in % [:closed-overs] merge ;; propagate closed-overs from the inner frame to the outer frame
                                      (into {}
                                            (remove (fn [[_ {:keys [local]}]] ;; remove deftype fields from the closed-over locals
                                                      (and (isa? @h :op/deftype op)
                                                           (isa? @h :local/field local)))
                                                    (apply dissoc closed-overs        ;; remove from the closed-overs locals that were
                                                           (:locals @*collects*)))))) ;; local to the inner frame
        (assoc ast :closed-overs closed-overs))
      (-collect-closed-overs ast))))

(defn collect-closed-overs
  "Attach closed-overs info to the AST as specified by the passes opts:
   * :where       set of :op nodes where to attach the closed-overs
   * :top-level?  if true attach closed-overs info to the top-level node

   The info will be attached in the :closed-overs field of the AST node
   and will be a map of local name -> binding AST node"
  {:pass-info {:walk :none :depends #{#'uniquify-locals}}}
  [ast]
  (let [passes-opts                   (:passes-opts (env/deref-env))
        {:keys [top-level?] :as opts} {:where      (or (:collect-closed-overs/where passes-opts) #{})
                                       :top-level? (:collect-closed-overs/top-level? passes-opts)}]
    (binding [*collects* (atom (merge opts {:closed-overs {} :locals #{}}))]
      (let [ast (collect-closed-overs* ast)]
        (if top-level?
          (assoc ast :closed-overs (:closed-overs @*collects*))
          ast)))))
