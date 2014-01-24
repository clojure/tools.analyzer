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
(defmulti -collect-closed-over :op)

(defmethod -collect-const       :default [ast] ast)
(defmethod -collect-callsite    :default [ast] ast)
(defmethod -collect-closed-over :default [ast] ast)

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

(defmethod -collect-closed-over :local
  [{:keys [op name] :as ast}]
  (swap! *collects* update-in [:closed-overs] assoc name (dissoc ast :env :atom))
  ast)

(defmethod -collect-closed-over :binding
  [{:keys [init name tag] :as ast}]
  (swap! *collects* update-in [:closed-overs] dissoc name)
  ast)

(defmethod -collect-closed-over :fn-method
  [{:keys [params] :as ast}]
  (swap! *collects* update-in [:closed-overs]
           #(apply dissoc % (mapv :name params)))
  ast)

(defmethod -collect-closed-over :method
  [{:keys [params] :as ast}]
  (swap! *collects* update-in [:closed-overs]
           #(apply dissoc % (mapv :name params)))
  ast)

(defmethod -collect-closed-over :fn
  [{:keys [name] :as ast}]
  (swap! *collects* update-in [:closed-overs] dissoc name)
  ast)

(defmethod -collect-closed-over :let
  [ast]
  (update-in ast [:bindings] #(mapv (:collect @*collects*) %)))

(defmethod -collect-closed-over :loop
  [ast]
  (update-in ast [:bindings] #(mapv (:collect @*collects*) %)))

(defn collect-fns [what]
  (case what
    :constants    -collect-const
    :closed-overs -collect-closed-over
    :callsites    -collect-callsite
    nil))

(defn merge-collects [{:keys [op fields] :as ast}]
  (let [{:keys [where what] :as collects} @*collects*]
    (merge ast (dissoc collects :where :what)
           (when (and (= :deftype op)
                      (:closed-overs what))
             {:closed-overs
              (zipmap (mapv :name fields)
                      (map (fn [ast] (dissoc ast :env)) fields))}))))

(defn -collect [{:keys [op] :as ast} collect-fn]
  (let [{:keys [where what] :as collects} @*collects*
        collect? (where op)

        ast (with-bindings
              (if collect? {#'*collects* (atom collects)} {})
              (let [ast (-> ast (update-children #(-collect % collect-fn) (comp vec rseq))
                           collect-fn)]
                (if collect?
                  (merge-collects ast)
                  ast)))]
    (when (and collect? (:closed-overs what) (not (= :deftype op)))
      (swap! *collects* update-in [:closed-overs] merge (:closed-overs ast)))
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
    (binding [*collects* (atom (merge {:constants           {}
                                       :protocol-callsites #{}
                                       :keyword-callsites  #{}
                                       :where              #{}
                                       :what               #{}
                                       :closed-overs        {}
                                       :collect             this}
                                      opts))]
      (let [ast (-collect ast (apply comp (keep collect-fns what)))]
        (if top-level?
          (merge-collects ast)
          ast)))))
