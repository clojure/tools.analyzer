;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes
  "Utilities for passes handling and for AST walking/updating")

(defn cycling
  "Combine the given passes in a single pass that will be repeatedly
   applied to the AST until applying it another time will have no effect"
  [& fns*]
  (let [fns (cycle fns*)]
    (fn [ast]
      (loop [[f & fns] fns ast ast res (zipmap fns* (repeat nil))]
        (let [ast* (f ast)]
          (if (= ast* (res f))
            ast
            (recur fns ast* (assoc res f ast*))))))))

(defn children*
  "Return a vector of the children expression of the AST node, if it has any.
   The returned vector returns the childrens in the order as they appear in the
   :children field of the AST, and may be either a node or a vector of nodes."
  [{:keys [children] :as ast}]
  (when children
    (mapv ast children)))

(defn children
  "Return a vector of the children expression of the AST node, if it has any.
   The children expressions are kept in order and flattened so that the returning
   vector contains only nodes and not vectors of nodes."
  [ast]
  (vec (mapcat (fn [c] (if (vector? c) c [c]))
               (children* ast))))

(defn update-children
  "Applies `f` to the nodes in the AST nodes children.
   Optionally applies `fix` to the children before applying `f` to the
   children nodes and then applies `fix` to the update children.
   An example of a useful `fix` function is `rseq`."
  ([ast f] (update-children ast f identity))
  ([ast f fix]
     (if-let [c (children* ast)]
       (reduce (fn [ast [k v]]
                 (assoc ast k (if (vector? v)
                                (fix (mapv f (fix v)))
                                (f v))))
               ast (map list (fix (:children ast)) (fix c)))
       ast)))

(defn walk
  "Walk the ast applying pre when entering the nodes, and post when exiting.
   If reversed? is not-nil, pre and post will be applied starting from the last
   children of the AST node to the first one."
  ([ast pre post]
     (walk ast pre post false))
  ([ast pre post reversed?]
     (let [fix (if reversed? (comp vec rseq) identity)
           walk #(walk % pre post reversed?)]
       (post (update-children (pre ast) walk fix)))))

(defn prewalk
  "Shortrand for (walk ast f identity)"
  [ast f]
  (walk ast f identity))

(defn postwalk
  "Shortrand for (walk ast identity f reversed?)"
  ([ast f]
     (walk ast identity f false))
  ([ast f reversed?]
     (walk ast identity f reversed?)))
