;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.collect
  (:require [clojure.tools.analyzer.utils :refer [protocol-node?]]
            [clojure.tools.analyzer.ast :refer [update-children]]))

(def ^:private ^:dynamic *collects*)

(defn -register-constant
  [form tag type]
  (let [key {:form form
             :meta (meta form)
             :tag  tag}
        {:keys [constants]} @*collects*]
    (or (:id (constants key))
        (let [id (count constants)]
          (swap! *collects* assoc-in [:constants key]
                   {:id   id
                    :tag  tag
                    :val  form
                    :type type})
          id))))

(defmulti -collect-const       :op)
(defmulti -collect-callsite    :op)

(defmethod -collect-const       :default [ast] ast)
(defmethod -collect-callsite    :default [ast] ast)

(defmethod -collect-const :const
  [{:keys [val tag type] :as ast}]
  (if (and (not= type :nil)
           (not= type :boolean))
    (let [id (-register-constant val tag type)]
      (assoc ast :id id))
    ast))

(defmethod -collect-const :def
  [{:keys [var] :as ast}]
  (let [id (-register-constant var clojure.lang.Var :var)]
    (assoc ast :id id)))

(defmethod -collect-const :var
  [{:keys [var] :as ast}]
  (let [id (-register-constant var clojure.lang.Var :var)]
    (assoc ast :id id)))

(defmethod -collect-const :the-var
  [{:keys [var] :as ast}]
  (let [id (-register-constant var clojure.lang.Var :var)]
    (assoc ast :id id)))

(defmethod -collect-callsite :keyword-invoke
  [{:keys [fn] :as ast}]
  (swap! *collects* update-in [:keyword-callsites] conj (:form fn))
  ast)

(defmethod -collect-callsite :protocol-invoke
  [{:keys [fn] :as ast}]
  (swap! *collects* update-in [:protocol-callsites] conj (:var fn))
  ast)

(defn collect-fns [what]
  (case what
    :constants    -collect-const
    :callsites    -collect-callsite
    nil))

(defn merge-collects [{:keys [op fields] :as ast}]
  (let [{:keys [where what] :as collects} @*collects*]
    (merge ast (dissoc collects :where :what))))

(defn -collect [{:keys [op] :as ast} collect-fn]
  (let [{:keys [where what] :as collects} @*collects*
        collect? (where op)

        ast (with-bindings
              (if collect? {#'*collects* (atom (merge collects
                                                      {:constants          {}
                                                       :protocol-callsites #{}
                                                       :keyword-callsites  #{}}))}
                  {})
              (let [ast (-> ast (update-children #(-collect % collect-fn))
                           collect-fn)]
                (if collect?
                  (merge-collects ast)
                  ast)))]
        ast))

(defmulti -collect-closed-overs :op)

(defn collect-closed-overs*
  [{:keys [op] :as ast}]
  (let [{:keys [where what] :as collects} @*collects*
        collect? (where op)]
    (if collect?
      (let [[ast {:keys [closed-overs locals]}]
            (binding [*collects* (atom (merge @*collects*
                                              {:closed-overs {} :locals #{}}))]
              [(update-children ast -collect-closed-overs) @*collects*])]
        (swap! *collects* update-in [:closed-overs] merge
               (apply dissoc (into {}
                                   (remove (fn [[_ {:keys [local]}]]
                                             (= :field local))
                                           closed-overs)) (:locals @*collects*)))
        (assoc ast :closed-overs closed-overs))
      (-collect-closed-overs ast))))

(defmethod -collect-closed-overs :default
  [ast]
  (update-children ast collect-closed-overs*))

(defmethod -collect-closed-overs :binding
  [{:keys [name init local] :as ast}]
  (let [ast (if init (update-in ast [:init] collect-closed-overs*) ast)]
    (if (= :field local)
      (swap! *collects* assoc-in [:closed-overs name] (dissoc ast :env :atom))
      (swap! *collects* update-in [:locals] conj name))
    ast))

(defmethod -collect-closed-overs :local
  [{:keys [name] :as ast}]
  (when-not ((:locals @*collects*) name)
    (swap! *collects* assoc-in [:closed-overs name] (dissoc ast :env :atom)))
  ast)

(defn collect-closed-overs
  [ast {:keys [what top-level?] :as opts}]
  (if (what :closed-overs)
    (binding [*collects* (atom (merge opts {:closed-overs {} :locals #{}}))]
      (collect-closed-overs* ast))
    ast))

(defn collect
  "Takes a map with:
   * :what        set of keywords describing what to collect, some of:
     ** :constants     constant expressions
     ** :closed-overs  closed over local bindings
     ** :callsites     keyword and protocol callsites
   * :where       set of :op nodes where to attach collected info
   * :top-level?  if true attach collected info to the top-level node"
  [{:keys [what top-level?] :as opts}]
  (fn this [ast]
    (-> (binding [*collects* (atom (merge {:constants           {}
                                          :protocol-callsites #{}
                                          :keyword-callsites  #{}
                                          :where              #{}
                                          :what               #{}}
                                         opts))]
         (let [ast (-collect ast (apply comp (keep collect-fns what)))]
           (if top-level?
             (merge-collects ast)
             ast)))
      (collect-closed-overs opts))))
