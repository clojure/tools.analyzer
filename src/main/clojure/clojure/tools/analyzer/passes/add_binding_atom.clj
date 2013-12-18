;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.add-binding-atom
  (:require [clojure.tools.analyzer.ast :refer [prewalk]]
            [clojure.tools.analyzer.utils :refer [update!]]))

(def ^:dynamic ^:private *bindings* {})

(defmulti ^:private -add-binding-atom :op)

(defmethod -add-binding-atom :default [ast] ast)

(defmethod -add-binding-atom :binding
  [{:keys [name] :as ast}]
  (let [a (atom {})]
    (update! *bindings* assoc name a)
    (assoc ast :atom a)))

(defmethod -add-binding-atom :local
  [{:keys [name] :as ast}]
  (assoc ast :atom (or (*bindings* name)
                       (atom {}))))

(defn add-binding-atom
  "Walks the AST and adds an atom-backed-map to every local binding,
   the same atom will be shared between all occurences of that local.

   The atom is put in the :atom field of the node."
  [ast]
  (binding [*bindings* *bindings*]
    (prewalk ast -add-binding-atom)))
