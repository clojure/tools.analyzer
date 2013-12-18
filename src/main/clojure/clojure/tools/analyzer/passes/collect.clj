;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.collect
  (:require [clojure.tools.analyzer.utils :refer [protocol-node? update!]]
            [clojure.tools.analyzer.ast :refer [postwalk]]))

(def ^:private ^:dynamic *collects*
  {:constants           {}
   :closed-overs        {}
   :protocol-callsites #{}
   :keyword-callsites  #{}})

(defn -register-constant
  [form tag type]
  (or (:id ((:constants *collects*) [form (meta form) tag]))
      (let [id (count (:constants *collects*))]
        (update! *collects* assoc-in [:constants {:form form
                                                  :meta (meta form)
                                                  :tag  tag}]
                 {:id   id
                  :tag  tag
                  :val  form
                  :type type})
        id)))

(defn -collect-constants
  [{:keys [op var form tag type] :as ast}]
  (if (and (= op :const)
           (not= type :nil)
           (not= type :boolean))
    (let [id (-register-constant form tag type)]
      (assoc ast :id id))
    (if (#{:def :var :the-var} op)
      (let [id (-register-constant var clojure.lang.Var :var)]
        (assoc ast :id id))
      ast)))

(defn -collect-callsites
  [{:keys [op fn] :as ast}]
  (when (= :keyword-invoke op)
    (update! *collects* update-in [:keyword-callsites] conj (:form fn)))

  (when (= :protocol-invoke op)
    (update! *collects* update-in [:protocol-callsites] conj (:var fn)))
  ast)

(defmulti -collect-closed-overs :op)
(defmethod -collect-closed-overs :default [ast] ast)

(defmethod -collect-closed-overs :local
  [{:keys [op name] :as ast}]
  (update! *collects* update-in [:closed-overs] assoc name (dissoc ast :env))
  ast)

(defmethod -collect-closed-overs :binding
  [{:keys [init name tag] :as ast}]
  (update! *collects* update-in [:closed-overs] dissoc name)
  (when init
    (-collect-closed-overs init)) ;; since we're in a postwalk, a bit of trickery is necessary
  ast)

(defmethod -collect-closed-overs :fn-method
  [{:keys [params] :as ast}]
  (update! *collects* update-in [:closed-overs]
           #(apply dissoc % (mapv :name params)))
  ast)

(defmethod -collect-closed-overs :method
  [{:keys [params] :as ast}]
  (update! *collects* update-in [:closed-overs]
           #(apply dissoc % (mapv :name params)))
  ast)

(defmethod -collect-closed-overs :fn
  [{:keys [name] :as ast}]
  (update! *collects* update-in [:closed-overs] dissoc name)
  ast)

(defn collect-fns [what]
  (case what
    :constants    -collect-constants
    :closed-overs -collect-closed-overs
    :callsites    -collect-callsites
    nil))

(defn collect
  "Takes a map with:
   * :what        set of keywords describing what to collect, some of:
     ** :constants     constant expressions
     ** :closed-overs  closed over local bindings
     ** :callsites     keyword and protocol callsites
   * :where       set of :op nodes where to attach collected info
   * :top-level?  if true attach collected info to the top-level node"
  [{:keys [what where top-level?]}]
  (fn [ast]
    (binding [*collects* *collects*]
      (let [f              (apply comp (keep collect-fns what))
            merge-collects (fn [{:keys [op] :as ast}]
                             (into ast (merge *collects*
                                              (when (and (= :deftype op)
                                                         (:closed-overs what))
                                                {:closed-overs
                                                 (zipmap (mapv :name (:fields ast))
                                                         (map (fn [ast] (dissoc ast :env))
                                                              (:fields ast)))}))))
            collect*       (fn [{:keys [op] :as ast}]
                             (let [ast (f ast)]
                               (if (where op)
                                 (merge-collects ast)
                                 ast)))
            ast            (postwalk ast collect* :reversed)]
        (if top-level?
          (merge-collects ast)
          ast)))))
