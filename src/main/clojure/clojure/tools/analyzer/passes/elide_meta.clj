;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.elide-meta)

(def ^:dynamic elides
  "Set of map keys to elide from metadata."
  (set (:elide-meta *compiler-options*)))

(defn dissoc-meta [{:keys [op form keys vals env] :as meta}]
  (let [form (apply dissoc form elides)]
    (if (= :const op)
      (assoc meta :form form)
      (let [new-meta (mapv (fn [{:keys [form] :as k} v]
                               (when-not (elides form)
                                 [k v]))
                             keys vals)]
        (assoc meta
          :form form
          :keys (mapv first new-meta)
          :vals (mapv second new-meta))))))

(defmulti -elide-meta :op)

(defmethod -elide-meta :with-meta
  [{:keys [meta expr env] :as ast}]
  (let [new-meta (apply dissoc (:form meta) elides)]
    (if (not (empty? new-meta))
      (if (= new-meta (:form meta))
        ast
        (let [new-meta (dissoc-meta meta)]
          (assoc ast :meta new-meta)))
      (assoc-in expr [:env :context] (:context env)))))

(defmethod -elide-meta :def
  [{:keys [meta env] :as ast}]
  (let [new-meta (apply dissoc (:form meta) elides)]
    (if (not (empty? new-meta))
      (if (= new-meta (:form meta))
        ast
        (let [new-meta (dissoc-meta meta)]
          (assoc ast :meta new-meta)))
      (dissoc ast :meta))))

(defmethod -elide-meta :default [ast] ast)

(defn elide-meta
  "If elides is not empty and the AST node contains metadata,
   dissoc all the keys in elides from the metadata."
  [ast]
  (if (seq elides)
    (-elide-meta ast)
    ast))
