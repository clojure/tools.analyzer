;:   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.collect
  (:require [clojure.tools.analyzer.utils :refer [protocol-node? update! const-val]]
            [clojure.tools.analyzer.passes :refer [postwalk]]))

(def ^:private ^:dynamic *collects*
  {:constants           {}
   :closed-overs        {}
   :protocol-callsites #{}
   :keyword-callsites  #{}})

(defn -register-constant
  [form tag type]
  (or (:id ((:constants *collects*) form))
      (let [id (count (:constants *collects*))]
        (update! *collects* assoc-in [:constants [form (meta form) tag]]
                 {:id   id
                  :tag  tag
                  :val  form
                  :type type})
        id)))

(defmulti -collect-constants :op)
(defmethod -collect-constants :default [ast] ast)

(defmethod -collect-constants :const
  [{:keys [form tag type] :as ast}]
  (if (and (not= type :nil)
           (not= type :boolean))
    (let [id (-register-constant form tag type)]
      (assoc ast :id id))
    ast))

(defmethod -collect-constants :var
  [{:keys [var] :as ast}]
  (let [id (-register-constant var clojure.lang.Var :var)]
    (assoc ast :id id)))

(defmethod -collect-constants :the-var
  [{:keys [var] :as ast}]
  (let [id (-register-constant var clojure.lang.Var :var)]
    (assoc ast :id id)))

(defmethod -collect-constants :def
  [{:keys [var] :as ast}]
  (let [id (-register-constant var clojure.lang.Var :var)]
    (assoc ast :id id)))

(defmethod -collect-constants :map
  [{:keys [keys vals tag] :as ast}]
  (let [map (apply hash-map (mapcat (fn [k v]
                                      (when (and (:literal? k)
                                                 (:literal? v))
                                        [(const-val k) (const-val v)])) keys vals))]
    (if (seq map)
      (let [id (-register-constant map tag :map)]
        (assoc ast :id id :const map))
      ast)))

(defmethod -collect-constants :set
  [{:keys [items tag] :as ast}]
  (let [set (into #{} (mapv const-val (filter :literal? items)))]
    (if (seq set)
      (let [id (-register-constant set tag :set)]
        (assoc ast :id id :const set))
      ast)))

(defn -collect-callsites
  [{:keys [op] :as ast}]
  (when (#{:keyword-invoke :invoke} op)
    (let [f (:fn ast)]
      (cond
       (and (= :var (:op f))
            (protocol-node? (:var f)))
       (update! *collects* update-in [:protocol-callsites] conj (:var f))

       (= :keyword-invoke op)
       (update! *collects* update-in [:keyword-callsites] conj (:form f)))))
  ast)

(defmulti -collect-closed-overs :op)
(defmethod -collect-closed-overs :default [ast] ast)

(defmethod -collect-closed-overs :local
  [{:keys [op name] :as ast}]
  (update! *collects* update-in [:closed-overs] assoc name ast)
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

(defn collect [& what]
  (fn [{:keys [op env] :as ast}]
    (if (#{:fn :deftype :reify} op)
      (binding [*collects* *collects*]
        (let [f (apply comp (filter identity (mapv collect-fns what)))]
          (let [ast (postwalk ast f :reversed)
                *collects* (merge *collects*
                                  (when (and (= :deftype op)
                                             (:closed-overs (set what)))
                                    {:closed-overs
                                     (zipmap (mapv :name (:fields ast)) (:fields ast))}))]
            (into ast *collects*))))
      ast)))
