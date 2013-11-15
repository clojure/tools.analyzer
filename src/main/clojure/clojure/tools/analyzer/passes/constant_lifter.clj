;:   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.constant-lifter
  (:require [clojure.tools.analyzer :refer [-analyze]]
            [clojure.tools.analyzer.utils :refer [constant? const-val classify]]))

(defmulti constant-lift
  "If op is :vector/:set/:map, and every item of the collection is a literal
   and the collection ha no metadata or if op is :var and the var has :const
   metadata, transform the node to an equivalent :const node."
  :op)

(defmethod constant-lift :vector
  [{:keys [items form env] :as ast}]
  (if (and (every? :literal? items)
           (not (meta form)))
    (-analyze :const (mapv const-val items) env :vector)
    ast))

(defmethod constant-lift :map
  [{:keys [keys vals form env] :as ast}]
  (if (and (every? :literal? keys)
           (every? :literal? vals)
           (not (meta form)))
    (-analyze :const (into (empty form)
                           (zipmap (map const-val keys)
                                   (map const-val vals))) env :map)
    ast))

(defmethod constant-lift :set
  [{:keys [items form env] :as ast}]
  (if (and (every? :literal? items)
           (not (meta form)))
    (-analyze :const (into (empty form)
                           (set (mapv const-val items))) env :set)
    ast))

;; this is actually jvm specific, should we move it?
(defmethod constant-lift :var
  [{:keys [var env] :as ast}]
  (if (constant? var)
    (let [val @var]
     (-analyze :const val env (classify val)))
    ast))

(defmethod constant-lift :default [ast] ast)
