;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.uniquify
  (:require [clojure.tools.analyzer.utils :refer [update!]]
            [clojure.tools.analyzer.passes :refer [update-children children]]))

(def ^:dynamic *locals-counter* {})
(def ^:dynamic *locals-frame* {})

(defn normalize [name]
  (if-let [idx (*locals-frame* name)]
    (symbol (str name "__#" idx))
    name))

(defn uniquify [name]
  (update! *locals-counter* update-in [name] (fnil inc -1))
  (update! *locals-frame* assoc-in [name] (*locals-counter* name)))

(defmulti -uniquify-locals :op)

(defn uniquify-locals* [ast]
  (update-children ast -uniquify-locals))

(defmethod -uniquify-locals :fn
  [{:keys [name] :as ast}]
  (binding [*locals-frame* *locals-frame*]
    (when name
      (uniquify name))
    (uniquify-locals* ast)))

(defmethod -uniquify-locals :local
  [{:keys [name local init] :as ast}]
  (if (not= :field local)
    (let [name (normalize name)]
      (assoc ast :name name))
    ast))

(defn uniquify-binding
  [{:keys [init name] :as b}]
  (let [i (binding [*locals-frame* *locals-frame*]
            (-uniquify-locals init))]
    (uniquify name)
    (let [name (normalize name)]
      (assoc b
        :name name
        :init i))))

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

(defmethod -uniquify-locals :default
  [ast]
  (if (some (comp #{:binding} :op) (children ast))
    (binding [*locals-frame* *locals-frame*]
      (uniquify-locals* ast))
    (uniquify-locals* ast)))

(defn uniquify-locals
  "Walks the AST performing alpha-conversion on local
   bindings' :name field"
  [ast]
  (binding [*locals-counter* *locals-counter*]
    (-uniquify-locals ast)))
