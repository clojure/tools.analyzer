;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.elide-meta
  (:require [clojure.tools.analyzer :refer [h]]
            [clojure.tools.analyzer.passes.source-info :refer [source-info]]))

(def ^:dynamic elides
  "A map of op keywords to predicate IFns.
   The predicate will be used to indicate what map keys should be elided on
   metadata of nodes for that op.
   :all can be used to indicate what should be elided for every node with
   metadata.
   Defaults to {:all (set (:elide-meta *compiler-options*))}"
  {:all (set (:elide-meta *compiler-options*))})

(defn replace-meta [meta new-meta]
  (if (isa? @h :op/const (:op meta))
    (assoc meta :val  new-meta)
    (let [meta-map (mapv (fn [k v]
                           (when-not (elides (:form k))
                             [k v]))
                         (:keys meta) (:vals meta))]
      (assoc meta
        :keys (vec (keep first meta-map))
        :vals (vec (keep second meta-map))))))

(defn get-elides [{:keys [op expr type]}]
  (let [k (cond
           (isa? @h :op/with-meta op)
           (:op expr)

           (isa? @h :op/const op)
           type

           :else
           nil)
        f (reduce-kv (fn [f op v] (when (isa? @h op k)
                                   (reduced v))) nil (dissoc elides :all))]
    (if f
      (some-fn (:all elides) f)
      (:all elides))))

(defn -elide-meta
  [{:keys [op meta expr env] :as ast}]
  (let [form (:form meta)
        new-meta (apply dissoc form (filter (get-elides ast) (keys form)))]
    (cond
     (isa? @h :op/const op)
     (if (or (not meta)
             (= new-meta (:form meta)))
       ast
       (if (not (empty? new-meta))
         (assoc-in ast [:meta :val] new-meta)
         (-> ast
           (update-in [:val] with-meta nil)
           (dissoc :children :meta))))
     (isa? @h :op/with-meta op)
     (if (not (empty? new-meta))
       (if (= new-meta (:form meta))
         ast
         (assoc ast :meta (replace-meta meta new-meta)))

       (merge (dissoc ast :meta :expr)
              {:op         :op/do
               :body?      true
               :ret        expr
               :statements []
               :children   [:statements :ret]}))
     (isa? @h :op/def op)
     (if (not (empty? new-meta))
       (if (= new-meta (:form meta))
         ast
         (assoc ast :meta (replace-meta meta new-meta)))
       (assoc (dissoc ast :meta) :children [:init]))

     :else
     ast)))

(defn elide-meta
  "If elides is not empty and the AST node contains metadata,
   dissoc all the keys in elides from the metadata."
  {:pass-info {:walk :any :depends #{} :after #{#'source-info}}}
  [ast]
  (if (some #(if (seq? %) (seq %) %) (vals elides))
    (-elide-meta ast)
    ast))
