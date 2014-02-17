;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.uniquify
  (:require [clojure.tools.analyzer.ast :refer [update-children children]]))

(def ^:dynamic *locals-counter*) ;; global counter, map sym -> count
(def ^:dynamic *locals-frame*)   ;; holds the id for the locals in the current frame

(defn normalize [name]
  (if-let [idx (@*locals-frame* name)]
    (symbol (str name "__#" idx))
    name))

(defn uniquify [name]
  (swap! *locals-counter* #(update-in % [name] (fnil inc -1)))
  (swap! *locals-frame* #(assoc-in % [name] (@*locals-counter* name))))

(defmulti -uniquify-locals :op)

(defn uniquify-locals* [ast]
  (update-children ast -uniquify-locals))

(defmethod -uniquify-locals :local
  [ast]
  (if (= :field (:local ast)) ;; deftype fields cannot be uniquified
    ast                       ;; to allow field access/set! to work
    (let [name (normalize (:name ast))]
      (assoc ast :name name))))

(defn uniquify-binding
  [b]
  (let [i (binding [*locals-frame* (atom @*locals-frame*)] ;; inits need to be uniquified before the local
            (-uniquify-locals (:init b)))                  ;; to avoid potential shadowings
        name (:name b)]
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

    (do (uniquify name)
        (assoc ast :name (normalize name)))))

(defmethod -uniquify-locals :default
  [ast]
  (if (some #(= :binding (:op %)) (children ast))
    (binding [*locals-frame* (atom @*locals-frame*)] ;; set up frame so locals won't leak
      (uniquify-locals* ast))
    (uniquify-locals* ast)))

(defn uniquify-locals
  "Walks the AST performing alpha-conversion on local
   bindings' :name field"
  [ast]
  (binding [*locals-counter* (atom {})
            *locals-frame*   (atom {})]
     (-uniquify-locals ast)))
