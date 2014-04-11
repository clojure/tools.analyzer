;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.elide-meta)

(def ^:dynamic elides
  "Set of map keys to elide from metadata.
   Defaults to (set (:elide-meta *compiler-options*))"
  (set (:elide-meta *compiler-options*)))

(defn replace-meta [meta new-meta]
  (if (= :const (:op meta))
    (assoc meta :form new-meta)
    (let [meta-map (mapv (fn [k v]
                       (when-not (elides (:form k))
                         [k v]))
                     (:keys meta) (:vals meta))]
      (assoc meta
        :form new-meta
        :keys (into [] (keep first meta-map))
        :vals (into [] (keep second meta-map))))))

(defn -elide-meta
  [{:keys [op meta expr env] :as ast}]
  (case op
    :with-meta
    (let [new-meta (apply dissoc (:form meta) elides)]
      (if (not (empty? new-meta))
        (if (= new-meta (:form meta))
          ast
          (assoc ast :meta (replace-meta meta new-meta)))
        (assoc-in expr [:env :context] (:context env))))
    :def
    (let [new-meta (apply dissoc (:form meta) elides)]
      (if (not (empty? new-meta))
        (if (= new-meta (:form meta))
          ast
          (assoc ast :meta (replace-meta meta new-meta)))
        (dissoc ast :meta)))
    ast))

(defn elide-meta
  "If elides is not empty and the AST node contains metadata,
   dissoc all the keys in elides from the metadata."
  [ast]
  (if (seq elides)
    (-elide-meta ast)
    ast))
