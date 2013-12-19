;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.emit-form)

(defmulti -emit-form (fn [{:keys [op]} _] op))

(def ^:dynamic -emit-form* -emit-form)

(defn emit-form
  "Return the form represented by the given AST"
  [ast]
  (-emit-form* ast false))

(defn emit-hygienic-form
  "Return an hygienic form represented by the given AST"
  [ast]
  (-emit-form* ast true))

(defmethod -emit-form :maybe-class
  [{:keys [class]} hygienic?]
  class)

(defmethod -emit-form :maybe-host-form
  [{:keys [class field]} hygienic?]
  (symbol (name class) (name field)))

(defmethod -emit-form :host-call
  [{:keys [target method args]} hygienic?]
  (list '. (-emit-form* target hygienic?)
        (list* method (mapv #(-emit-form* % hygienic?) args))))

(defmethod -emit-form :host-field
  [{:keys [target field]} hygienic?]
  (list (symbol (str ".-" (name field)))
        (-emit-form* target hygienic?)))

(defmethod -emit-form :host-interop
  [{:keys [target m-or-f]} hygienic?]
  (list '. (-emit-form* target hygienic?) m-or-f))

(defmethod -emit-form :local
  [{:keys [name form]} hygienic?]
  (if hygienic? (with-meta name (meta form)) form))

(defmethod -emit-form :binding
  [{:keys [name form]} hygienic?]
  (if hygienic? (with-meta name (meta form)) form))

(defmethod -emit-form :var
  [{:keys [form]} hygienic?]
  form)

(defn emit-bindings [bindings hygienic?]
  (mapcat (fn [{:keys [name form init]}]
            [(if hygienic? name form) (-emit-form* init hygienic?)])
          bindings))

(defmethod -emit-form :letfn
  [{:keys [bindings body]} hygienic?]
  `(letfn* [~@(emit-bindings bindings hygienic?)]
           ~(-emit-form* body hygienic?)))

(defmethod -emit-form :let
  [{:keys [bindings body]} hygienic?]
  `(let* [~@(emit-bindings bindings hygienic?)]
           ~(-emit-form* body hygienic?)))

(defmethod -emit-form :loop
  [{:keys [bindings body]} hygienic?]
  `(loop* [~@(emit-bindings bindings hygienic?)]
           ~(-emit-form* body hygienic?)))

(defmethod -emit-form :const
  [{:keys [form quoted?]} _]
  form)

(defmethod -emit-form :quote
  [{:keys [expr]} hygienic?]
  (list 'quote (-emit-form* expr hygienic?)))

(defmethod -emit-form :vector
  [{:keys [items]} hygienic?]
  (mapv #(-emit-form* % hygienic?) items))

(defmethod -emit-form :set
  [{:keys [items]} hygienic?]
  (set (mapv #(-emit-form* % hygienic?) items)))

(defmethod -emit-form :map
  [{:keys [keys vals]} hygienic?]
  (apply hash-map (interleave (mapv #(-emit-form* % hygienic?) keys)
                              (mapv #(-emit-form* % hygienic?) vals))))

(defmethod -emit-form :with-meta
  [{:keys [expr meta]} hygienic?]
  (with-meta (-emit-form* expr hygienic?)
    (-emit-form* meta hygienic?)))

(defmethod -emit-form :do
  [{:keys [ret statements]} hygienic?]
  (if (seq statements)
    `(do ~@(mapv #(-emit-form* % hygienic?) statements)
         ~(-emit-form* ret hygienic?))
    (-emit-form* ret hygienic?)))

(defmethod -emit-form :if
  [{:keys [test then else]} hygienic?]
  `(if ~(-emit-form* test hygienic?)
     ~(-emit-form* then hygienic?)
     ~@(when-not (nil? (:form else))
         [(-emit-form* else hygienic?)])))

(defmethod -emit-form :new
  [{:keys [class args]} hygienic?]
  `(new ~class ~@(mapv #(-emit-form* % hygienic?) args)))

(defmethod -emit-form :set!
  [{:keys [target val]} hygienic?]
  `(set! ~(-emit-form* target hygienic?) ~(-emit-form* val hygienic?)))

(defmethod -emit-form :recur
  [{:keys [exprs]} hygienic?]
  `(recur ~@(mapv #(-emit-form* % hygienic?) exprs)))

(defmethod -emit-form :fn-method
  [{:keys [variadic? params body form]} hygienic?]
  (let [params-form (mapv #(-emit-form* % hygienic?) params)]
    `(~(with-meta
         (if variadic? (into (pop params-form)
                             (conj '[&] (peek params-form)))
             params-form)
         (meta (first form)))
      ~(-emit-form* body hygienic?))))

(defmethod -emit-form :fn
  [{:keys [local methods]} hygienic?]
  `(fn* ~@(when local [(-emit-form* local hygienic?)])
        ~@(mapv #(-emit-form* % hygienic?) methods)))

(defmethod -emit-form :def
  [{:keys [name doc init]} hygienic?]
  (let [name (if-let [arglists (:arglists (meta name))]
               (with-meta name (assoc (meta name) :arglists (list 'quote arglists)))
               name)]
    `(def ~name ~@(when doc [doc]) ~@(when init [(-emit-form* init hygienic?)]))))

(defmethod -emit-form :invoke
  [{:keys [fn args]} hygienic?]
  `(~(-emit-form* fn hygienic?)
    ~@(mapv #(-emit-form* % hygienic?) args)))

(defmethod -emit-form :try
  [{:keys [body catches finally]} hygienic?]
  `(try ~(-emit-form* body hygienic?)
        ~@(mapv #(-emit-form* % hygienic?) catches)
        ~@(when finally
            [`(finally ~(-emit-form* finally hygienic?))])))

(defmethod -emit-form :catch
  [{:keys [class local body]} hygienic?]
  `(catch ~class ~(-emit-form* local hygienic?)
     ~(-emit-form* body hygienic?)))

(defmethod -emit-form :throw
  [{:keys [exception]} hygienic?]
  `(throw ~(-emit-form* exception hygienic?)))
