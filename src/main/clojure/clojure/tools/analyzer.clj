;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer
  "Analyzer for clojure code, host agnostic.

   Entry point:
   * analyze

   Platform implementers must provide dynamic bindings for:
   * macroexpand-1
   * parse
   * create-var
   * var?

   See clojure.tools.analyzer.core-test for an example on how to setup the analyzer."
  (:refer-clojure :exclude [macroexpand-1 macroexpand var?])
  (:require [clojure.tools.analyzer.utils :refer :all]))

(defmulti -analyze (fn [op form env & _] op))
(defmulti -parse
  "Takes a form and an env map and dispatches on the head of the form, a special
   form."
  (fn [[op & rest] env] op))

(defn analyze
  "Given a form to analyze and an environment, a map containing:
   * :locals     a map from binding symbol to AST of the binding value
   * :context    a keyword describing the form's context, one of:
    ** :return     the form is in return position
    ** :statement  the return value of the form is not needed
    ** :expr       everything else
   * :ns         a symbol representing the current namespace of the form to be
                 analyzed, must be present in the :namespaces map
   * :namespaces an atom containing a map from namespace symbol to namespace map,
                 the namespace map contains the following keys:
    ** :mappings   a map of mappings of the namespace, symbol to var
    ** :aliases    a map of the aliases of the namespace, symbol to symbol
    ** :ns         a symbol representing the namespace
   returns an AST for that form.

   The AST is a map that is *guaranteed* to have the following keys:
   * :op   a keyword describing the AST node
   * :form the form represented by the AST node
   * :env  the environment map of the AST node

   Additionaly if the AST node contains sub-nodes, it is guaranteed to have:
   * :children a vector of the keys of the AST node mapping to the sub-nodes"

  [form {:keys [context] :as env}]
  (let [form (if (seq? form)
               (or (seq form) ()) ;; force evaluation for analysis
               form)]
    (cond

     (symbol? form)   (-analyze :symbol form env)

     (type? form)     (-analyze :const  form env :type)
     (record? form)   (-analyze :const  form env :record)

     (seq? form)      (-analyze :seq    form env)
     (vector? form)   (-analyze :vector form env)
     (map? form)      (-analyze :map    form env)
     (set? form)      (-analyze :set    form env)

     :else            (-analyze :const  form env))))

(defn empty-env
  "Returns an empty env"
  []
  {:context    :expr
   :locals     {}
   :ns         'user
   :namespaces (atom
                {'user {:mappings {}
                        :aliases  {}
                        :ns       'user}})})

(defn analyze-in-env
  "Takes an env map and returns a function that analyzes a form in that env"
  [env]
  (fn [form] (analyze form env)))

(def ^{:dynamic  true
       :arglists '([form env])
       :doc      "If form represents a macro form, returns its expansion,
                  else returns form."}
  macroexpand-1)

(def ^{:dynamic  true
       :arglists '([[op & args] env])
       :doc      "Multimethod that dispatches on op, should default to -parse"}
  parse)

(def ^{:dynamic  true
       :arglists '([sym env])
       :doc      "Creates a var for sym and returns it"}
  create-var)

(def ^{:dynamic  true
       :arglists '([obj])
       :doc      "Returns true if obj represent a var form as returned by create-var"}
  var?)

(defn wrapping-meta [{:keys [form env] :as expr}]
  (let [meta (meta form)]
    (if (and (obj? form)
             (seq meta))
      {:op       :with-meta
       :env      env
       :form     form
       :meta     (analyze meta (ctx env :expr))
       :expr     (assoc-in expr [:env :context] :expr)
       :children [:meta :expr]}
     expr)))

(defmethod -analyze :const
  [_ form env & [type]]
  (let [type (or type (classify form))
        m (meta form)]
    (merge
     {:op       :const
      :env      env
      :type     type
      :literal? true
      :val      form
      :form     form}
     (when (seq m)
       {:meta     (-analyze :const m (ctx env :expr) :map)
        :children [:meta]}))))

(defmethod -analyze :vector
  [_ form env]
  (let [items-env (ctx env :expr)
        items (mapv (analyze-in-env items-env) form)]
    (wrapping-meta
     {:op       :vector
      :env      env
      :items    items
      :form     form
      :children [:items]})))

(defmethod -analyze :map
  [_ form env]
  (let [kv-env (ctx env :expr)
        keys (keys form)
        vals (vals form)
        [ks vs] (map (partial mapv (analyze-in-env kv-env)) [keys vals])]
    (wrapping-meta
     {:op       :map
      :env      env
      :keys     ks
      :vals     vs
      :form     form
      :children [:keys :vals]})))

(defmethod -analyze :set
  [_ form env]
  (let [items-env (ctx env :expr)
        items (mapv (analyze-in-env items-env) form)]
    (wrapping-meta
     {:op       :set
      :env      env
      :items    items
      :form     form
      :children [:items]})))

(def specials
  "Set of special forms common to every clojure variant"
  '#{do if new quote set! try
     catch throw finally & def .
     let* letfn* loop* recur fn*})

(defn macroexpand
  "Repeatedly calls macroexpand-1 on form until it no longer
   represents a macro form, then returns it."
  [form env]
  (loop [mform (macroexpand-1 form env)]
    (if (= mform form)
      mform
      (recur mform))))

(defmethod -analyze :symbol
  [_ sym env]
  (let [mform (macroexpand-1 sym env)]
    (if (= mform sym)
      (merge (if-let [{:keys [mutable children] :as local-binding} (-> env :locals sym)]
               (merge (dissoc local-binding :init)
                      {:op          :local
                       :assignable? (boolean mutable)
                       :children    (vec (remove #{:init} children))})
               (if-let [var (let [v (resolve-var sym env)]
                              (and (var? v) v))]
                 {:op          :var
                  :assignable? (dynamic? var)
                  :var         var}
                 (if-let [maybe-class (namespace sym)] ;; e.g. js/foo.bar or Long/MAX_VALUE
                   (let [maybe-class (symbol maybe-class)]
                     (if-not (resolve-ns maybe-class env)
                       {:op    :maybe-host-form
                        :class maybe-class
                        :field (symbol (name sym))}
                       (throw (ex-info (str "could not resolve var: " sym)
                                       {:var mform}))))
                   {:op    :maybe-class ;; e.g. java.lang.Integer or Long
                    :class mform})))
             {:env  env
              :form mform})
      (analyze (if (obj? mform)
                 (with-meta mform (meta sym))
                 mform)
               env))))

(defmethod -analyze :seq
  [_ form env]
  (let [op (first form)]
    (if (nil? op)
      (ex-info "Can't call nil" {:form form}))
    (let [mform (macroexpand-1 form env)]
      (if (= form mform)
        (parse mform env) ;; invoke == :default
        (analyze (if (obj? mform)
                   (with-meta mform (meta form))
                   mform)
                 env)))))

(defn analyze-block
  [exprs env]
  (let [statements-env (ctx env :statement)
        statements (mapv (analyze-in-env statements-env)
                         (butlast exprs))
        ret (analyze (last exprs) env)]
    {:statements statements
     :ret        ret
     :children   [:statements :ret]}))

(defmethod -parse 'do
  [[_ & exprs :as form] env]
  (into {:op   :do
         :env  env
         :form form}
        (analyze-block exprs env)))

(defmethod -parse 'if
  [[_ test then else :as form] env]
  {:pre [(or (= 3 (count form))
             (= 4 (count form)))]}
  (let [test-expr (analyze test (ctx env :expr))
        then-expr (analyze then env)
        else-expr (analyze else env)]
    {:op   :if
     :form form
     :env  env
     :test test-expr
     :then then-expr
     :else else-expr
     :children `[:test :then :else]}))

(defmethod -parse 'new
  [[_ class & args :as form] env]
  {:pre [(>= (count form) 2)]}
  (let [args-env (ctx env :expr)
        args (mapv (analyze-in-env args-env) args)]
    {:op          :new
     :env         env
     :form        form
     :class       class
     :args        args
     :children    [:args]}))

(defmethod -parse 'quote
  [[_ expr :as form] env]
  (let [const (-analyze :const expr (assoc env :quoted? true))]
    {:op       :quote
     :expr     const
     :form     form
     :env      env
     :literal? true
     :children [:expr]}))

(defmethod -parse 'set!
  [[_ target val :as form] env]
  {:pre [(= (count form) 3)]}
  (let [target (analyze target (ctx env :expr))
        val (analyze val (ctx env :expr))]
    {:op       :set!
     :env      env
     :form     form
     :target   target
     :val      val
     :children [:target :val]}))

(defmethod -parse 'try
  [[_ & body :as form] {:keys [context] :as env}]
  (let [catch? (every-pred seq? #(= (first %) 'catch))
        finally? (every-pred seq? #(= (first %) 'finally))
        [body tail] (split-with (complement (some-fn catch? finally?)) body)
        [cblocks tail] (split-with catch? tail)
        [[fblock & fbs :as fblocks] tail] (split-with finally? tail)]
    (when-not (empty? tail)
      (throw (ex-info "only catch or finally clause can follow catch in try expression"
                      {:expr tail})))
    (when-not (empty? fbs)
      (throw (ex-info "only one finally clause allowed in try expression"
                      {:expr fblocks})))
    (let [body (parse (cons 'do body) (assoc env :in-try true :no-recur true))
          cenv (ctx env :expr)
          cblocks (mapv #(parse % cenv) cblocks)
          fblock (when-not (empty? fblock)
                   (parse (cons 'do (rest fblock)) (ctx env :statement)))]
      (merge {:op      :try
              :env     env
              :form    form
              :body    body
              :catches cblocks}
             (when fblock
               {:finally fblock})
             {:children `[:body :catches ~@(when fblock [:finally])]}))))

(defmethod -parse 'catch
  [[_ etype ename & body :as form] env]
  (if (and (symbol? ename)
           (not (namespace ename)))
    (let [local {:op    :binding
                 :env   env
                 :form  ename
                 :name  ename
                 :local :catch
                 :tag   etype}]
      {:op          :catch
       :class       etype
       :local       local
       :env         env
       :form        form
       :body        (parse (cons 'do body) (assoc-in env [:locals ename] local))
       :children    [:local :body]})
    (throw (ex-info (str "invalid binding form: " ename) {:sym ename}))))

(defmethod -parse 'throw
  [[_ throw :as form] env]
  {:op        :throw
   :env       env
   :form      form
   :exception (analyze throw (ctx env :expr))
   :children  [:exception]})

(defmethod -parse 'letfn*
  [[_ bindings & body :as form] {:keys [context] :as env}]
  {:pre [(vector? bindings)
         (even? (count bindings))]}
  (let [bindings (apply hash-map bindings)
        fns (keys bindings)]
    (when-not (every? #(and (symbol? %)
                       (not (namespace %)))
                 fns)
      (throw (ex-info (str "bad binding form: " (first (remove symbol? fns)))
                      {:form form})))
    (let [binds (reduce (fn [binds name]
                          (assoc binds name
                                 {:op    :binding
                                  :env   env
                                  :name  name
                                  :form  name
                                  :local :letfn}))
                        {} fns)
          e (update-in env [:locals] merge binds)
          binds (reduce-kv (fn [binds name bind]
                             (assoc binds name
                                    (merge bind
                                           {:init     (analyze (bindings name)
                                                               (ctx e :expr))
                                            :children [:init]})))
                           {} binds)
          e (update-in env [:locals] merge binds)
          body (parse (cons 'do body) e)]
      {:op       :letfn
       :env      env
       :form     form
       :bindings (vec (vals binds))
       :body     body
       :children [:bindings :body]})))

(defn analyze-let
  [[op bindings & body :as form] {:keys [context loop-id] :as env}]
  {:pre [(vector? bindings)
         (even? (count bindings))]}
  (let [loop? (= 'loop* op)]
    (loop [bindings (seq (partition 2 bindings))
           env (ctx env :expr)
           binds []]
      (if-let [[name init] (first bindings)]
        (if (or (namespace name)
                (.contains (str name) "."))
          (throw (ex-info (str "invalid binding form: " name)
                          {:sym name}))
          (let [init-expr (analyze init env)
                bind-expr {:op       :binding
                           :env      env
                           :name     name
                           :init     init-expr
                           :form     name
                           :local    (if loop? :loop :let)
                           :children [:init]}]
            (recur (next bindings)
                   (assoc-in env [:locals name] bind-expr)
                   (conj binds bind-expr))))
        (let [body-env (assoc env
                         :context (if loop? :return context))
              body (parse (cons 'do body)
                          (if loop?
                            (assoc body-env
                              :loop-id     loop-id
                              :loop-locals (mapv :form binds))
                            body-env))]
          {:body     body
           :bindings binds
           :children [:bindings :body]})))))

(defmethod -parse 'let*
  [form env]
  (into {:op   :let
         :form form
         :env  env}
        (analyze-let form env)))

(defmethod -parse 'loop*
  [form env]
  (let [loop-id (gensym "loop_")
        env (dissoc (assoc env :loop-id loop-id) :no-recur)]
    (into {:op      :loop
           :form    form
           :env     env
           :loop-id loop-id}
         (analyze-let form env))))

(defmethod -parse 'recur
  [[_ & exprs :as form] {:keys [context loop-locals loop-id no-recur]
                         :as env}]
  {:pre [(= :return context)
         loop-locals
         (not no-recur)
         (= (count exprs) (count loop-locals))]}
  (let [exprs (mapv (analyze-in-env (ctx env :expr))
                    exprs)]
    {:op          :recur
     :env         env
     :form        form
     :exprs       exprs
     :loop-id     loop-id
     :children    [:exprs]}))

(defn analyze-fn-method [[params & body :as form] {:keys [locals local] :as env}]
  {:pre [(every? symbol? params)]}
  (when (some namespace params)
    (throw (ex-info (str "unexpected namespace in parameter(s).  One possible source of mistake is a macro with x# in most places but x in a parameter list: " (seq (filter namespace params)))
                    {:params params})))
  (let [variadic? (boolean (some '#{&} params))
        params-names (vec (remove '#{&} params))
        env (dissoc env :local)
        arity (count params-names)
        params-expr (mapv (fn [name id]
                            {:env       env
                             :form      name
                             :name      name
                             :variadic? (and variadic?
                                             (= id (dec arity)))
                             :op        :binding
                             :arg-id    id
                             :local     :arg})
                          params-names (range))
        fixed-arity (if variadic?
                      (dec arity)
                      arity)
        loop-id (gensym "loop_")
        body-env (into (update-in env [:locals]
                                  merge (zipmap params-names params-expr))
                       {:context     :return
                        :loop-id      loop-id
                        :loop-locals (mapv :form params-expr)})
        body (parse (cons 'do body) body-env)]
    (when variadic?
      (let [x (drop-while #(not= % '&) params)]
        (when (not= 2 (count x))
          (throw (ex-info (str "unexpected parameter: " (first (drop 2 x)))
                          {:params params})))))
    (merge
     {:op          :fn-method
      :form        form
      :loop-id     loop-id
      :env         env
      :variadic?   variadic?
      :params      params-expr
      :fixed-arity fixed-arity
      :body        body
      :children    `[:params :body]}
     (when local
       {:local (dissoc local :env)}))))

(defmethod -parse 'fn*
  [[op & args :as form] {:keys [name] :as env}]
  (let [[n meths] (if (symbol? (first args))
                       [(first args) (next args)]
                       [nil (seq args)])
        name (or n name)
        name-expr {:op    :binding
                   :env   env
                   :form  name
                   :local :fn
                   :name  name}
        e (if n (assoc (assoc-in env [:locals name] name-expr) :local name-expr) env)
        menv (assoc (dissoc e :no-recur)
               :once (-> op meta :once boolean))
        meths (if (vector? (first meths)) (list meths) meths) ;;turn (fn [] ...) into (fn ([]...))
        methods-exprs (mapv #(analyze-fn-method % menv) meths)
        variadic (seq (filter :variadic? methods-exprs))
        variadic? (boolean variadic)
        fixed-arities (seq (map :fixed-arity (remove :variadic? methods-exprs)))
        max-fixed-arity (when fixed-arities (apply max fixed-arities))]
    (when (>= (count variadic) 2)
      (throw (ex-info "can't have more than 1 variadic overload"
                      {:variadics (mapv :form variadic)})))
    (when (not= (seq (distinct fixed-arities)) fixed-arities)
      (throw (ex-info "can't have 2 overloads with the same arity"
                      {:form form})))
    (when (and variadic?
               (not-every? #(<= (:fixed-arity %)
                          (:fixed-arity (first variadic)))
                      (remove :variadic? methods-exprs)))
      (throw (ex-info "Can't have fixed arity function with more params than variadic function"
                      {:form form})))
    (merge {:op              :fn
            :env             env
            :form            form
            :name            name
            :variadic?       variadic?
            :max-fixed-arity max-fixed-arity
            :methods         methods-exprs}
           (when n
             {:local name-expr})
           {:children `[~@(when n [:local]) :methods]})))

(defmethod -parse 'def
  [[_ sym & expr :as form] {:keys [ns namespaces] :as env}]
  {:pre [(symbol? sym)
         (or (not (namespace sym))
             (= *ns* (the-ns (symbol (namespace sym)))))]}
  (let [pfn (fn
              ([])
              ([init]
                 {:init init})
              ([doc init]
                 {:pre [(string? doc)]}
                 {:init init :doc doc}))
        args (apply pfn expr)

        doc (or (:doc args) (-> sym meta :doc))
        arglists (when-let [arglists (:arglists (meta sym))]
                   (second arglists)) ;; drop quote
        meta (merge (meta sym)
                    (-source-info form env)
                    (when doc {:doc doc}))

        sym (with-meta (symbol (name sym))
              meta)
        env (assoc env :name sym)

        sym (if arglists
              (vary-meta sym assoc :arglists arglists)
              sym)

        var (create-var sym env)
        _ (swap! namespaces assoc-in [ns :mappings sym] var)

        meta-expr (when meta (analyze meta
                                      (ctx env :expr)))

        args (when-let [[_ init] (find args :init)]
               (merge args {:init (analyze init (ctx env :expr))}))
        children `[~@(when meta [:meta])
                   ~@(when (:init args) [:init])]]

    (merge {:op   :def
            :env  env
            :form form
            :name sym
            :var  var}
           (when meta
             {:meta meta-expr}) ;; or meta?
           args
           (when-not (empty? children)
             {:children children}))))

(defmethod -parse '.
  [[_ target & [m-or-f & args] :as form] env]
  {:pre [(>= (count form) 3)]}
  (let [[m-or-f field?] (if (and (symbol? m-or-f)
                                 (= \- (first (name m-or-f))))
                          [(-> m-or-f name (subs 1) symbol) true]
                          [(if args (cons m-or-f args) m-or-f) false])
        target-expr (analyze target (ctx env :expr))
        call? (and (not field?) (seq? m-or-f))]

    (when (and call? (not (symbol? (first m-or-f))))
      (throw (ex-info (str "method name must be a symbol, had: " (class (first m-or-f)))
                      {:form form})))
    (merge {:form form
            :env  env}
           (cond
            call?
            {:op       :host-call
             :target   target-expr
             :method   (symbol (name (first m-or-f)))
             :args     (mapv (analyze-in-env (ctx env :expr)) (next m-or-f))
             :children [:target :args]}

            field?
            {:op       :host-field
             :target   target-expr
             :field    (symbol (name m-or-f))
             :children [:target]}

            :else
            {:op       :host-interop ;; either field access or single method call
             :target   target-expr
             :m-or-f   (symbol (name m-or-f))
             :children [:target]}))))

;; invoke
(defmethod -parse :default
  [[f & args :as form] env]
  (if-not f
    (-analyze :const form env)
    (let [e (ctx env :expr)
          fn-expr (analyze f e)
          args-expr (mapv (analyze-in-env e) args)
          m (meta form)]
      (merge {:op   :invoke
              :form form
              :env  env
              :fn   fn-expr
              :args args-expr}
             (when m
               {:meta m}) ;; this implies it's not going to be evaluated
       {:children [:args :fn]}))))
