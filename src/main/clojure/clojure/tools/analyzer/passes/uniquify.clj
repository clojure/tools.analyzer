;:   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.uniquify
  (:require [clojure.tools.analyzer.utils :refer [update!]]
            [clojure.tools.analyzer.passes :refer [walk]]))

(def ^:dynamic *locals* {})
(def ^:dynamic *locals-frame* {})
(def ^:dynamic *locals-init* {})

(defmulti -uniquify-locals :op)

(defn normalize [name]
  (if-let [idx (*locals-frame* name)]
    (symbol (str name "__#" idx))
    name))

(defn denormalize [name]
  (let [[_ s] (re-find #"(.+?)__#\d+" (str name))]
    (and s (symbol s))))

(defn uniquify [name]
  (when (not (*locals* (denormalize name)))
    (update! *locals* update-in [name] (fnil inc -1))
    (update! *locals-frame* assoc-in [name] (*locals* name))))

(defn uniquify-cleanup [name]
  (when-let [name (denormalize name)]
    (when (*locals* name)
      (update! *locals-frame* update-in [name] (fnil dec 0)))))

(declare uniquify-locals*)

(defmethod -uniquify-locals :local
  [{:keys [name local init] :as ast}]
  (if (not= :field local)
    (let [name (normalize name)]
      (merge ast
             {:name name}
             (when-let [init (*locals-init* name)]
               {:init init})))
    ast))

(defn uniquify-binding
  [{:keys [init name] :as b}]
  (let [init (binding [*locals-frame* *locals-frame*]
               (assoc (uniquify-locals* init)
                 :dont-cleanup? true))]
    (uniquify name)
    (let [name (normalize name)]
      (update! *locals-init* assoc name init)
      (assoc b
        :name name
        :init init))))

(defmethod -uniquify-locals :binding
  [{:keys [name local] :as ast}]
  (case local
    (:let :letfn :loop)
    (uniquify-binding ast)

    :field
    ast

    :fn
    (assoc ast :name (normalize name))

    (do (uniquify name)
        (assoc ast :name (normalize name)))))

(defmethod -uniquify-locals :default [ast] ast)

(defmethod -uniquify-locals :fn
  [{:keys [name] :as ast}]
  (if name
    (do (uniquify name)
        (assoc ast :name (normalize name)))
    ast))

(defn -uniquify-cleanup
  [{:keys [op bindings name local params dont-cleanup?] :as ast}]
  (when (not dont-cleanup?)
    (cond
     (#{:let :letfn :loop} op)
     (doseq [n (mapv :name bindings)]
       (uniquify-cleanup n))

     (= :fn op)
     (uniquify-cleanup name)

     (= :fn-method op)
     (doseq [n (mapv :name params)]
       (uniquify-cleanup n))

     (= :catch op)
     (uniquify-cleanup (:name local))))
  (dissoc ast :dont-cleanup?))

(defn uniquify-locals* [ast]
  (walk ast -uniquify-locals -uniquify-cleanup))

(defn uniquify-locals [ast]
  (binding [*locals*       *locals*
            *locals-frame* *locals-frame*
            *locals-init*  *locals-init*]
    (uniquify-locals* ast)))
