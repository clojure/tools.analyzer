(ns clojure.tools.analyzer.core-test
  (:refer-clojure :exclude [macroexpand-1])
  (:require [clojure.tools.analyzer :as ana]
            [clojure.tools.analyzer.ast :refer [postwalk]]
            [clojure.tools.analyzer.env :refer [with-env]]
            [clojure.tools.analyzer.passes.elide-meta :refer [elides elide-meta]]
            [clojure.test :refer [deftest is]]
            [clojure.tools.analyzer.utils :refer [resolve-var]]))

(defn desugar-host-expr [[op & expr :as form]]
  (if (symbol? op)
    (let [opname (name op)]
      (cond

       (= (first opname) \.) ; (.foo bar ..)
       (let [[target & args] expr
             args (list* (symbol (subs opname 1)) args)]
         (with-meta (list '. target (if (= 1 (count args)) ;; we don't know if (.foo bar) ia
                                      (first args) args)) ;; a method call or a field access
           (meta form)))

       (= (last opname) \.) ;; (class. ..)
       (with-meta (list* 'new (symbol (subs opname 0 (dec (count opname)))) expr)
         (meta form))

       :else form))
    form))

(defn macroexpand-1 [form env]
  (if (seq? form)
    (let [op (first form)]
      (if (ana/specials op)
        form
        (let [v (resolve-var op env)]
          (if (and (not (-> env :locals (get op))) ;; locals cannot be macros
                   (:macro (meta v)))
            (apply v form env (rest form)) ; (m &form &env & args)
            (desugar-host-expr form)))))
        form))

(defmacro foo [] 1)

(def e {:context    :ctx/expr
        :locals     {}
        :ns         'user})

(def e1 (atom {:namespaces {'user         {:mappings (into (ns-map 'clojure.core)
                                                           {'foo #'foo})
                                           :aliases  {}
                                           :ns       'user}
                            'clojure.core {:mappings (ns-map 'clojure.core)
                                           :aliases {}
                                           :ns      'clojure.core}}}))
(defmacro ast [form]
  `(binding [ana/macroexpand-1 macroexpand-1
             ana/create-var    ~(fn [sym env]
                                  (doto (intern (:ns env) sym)
                                    (reset-meta! (meta sym))))
             ana/parse         ana/-parse
             ana/var?          ~var?
             elides            {:all #{:line :column :file}}]
     (with-env e1
       (postwalk (ana/analyze '~form e) elide-meta))))

(defmacro mexpand [form]
  `(with-env e1
     (macroexpand-1 '~form e)))

(deftest analyzer-test

  (let [nil-ast (ast nil)]
    (is (= :const (:op nil-ast)))
    (is (= :nil (:type nil-ast)))
    (is (:literal? nil-ast)))

  (let [v-ast (ast ^:foo [1 2])]
    (is (= :with-meta (:op v-ast)))
    (is (= :map (-> v-ast :meta :op)))
    (is (= {:foo true} (-> v-ast :meta :form)))
    (is (= [1 2] (-> v-ast :expr :form))))

  (let [m-ast (ast {:a 1 :b 2})]
    (is (= {:a 1 :b 2} (:form m-ast)))
    (is (= [:a :b] (->> m-ast :keys (mapv :form))))
    (is (= [1 2] (->> m-ast :vals (mapv :form)))))

  (is (= 'a (mexpand a)))
  (is (= ::foo (mexpand ::foo)))
  (is (= '(new foo) (mexpand (foo.))))
  (is (= '(new foo a) (mexpand (foo. a))))
  (is (= 'foo/bar (mexpand foo/bar)))
  (is (= '(. bar (foo 1)) (mexpand (.foo bar 1))))
  (is (= '(. bar foo) (mexpand (.foo bar))))
  (is (= 1 (mexpand (user/foo))))

  (let [s-ast (:expr (ast '+))]
    (is (= :symbol (:type s-ast)))
    (is (= '+ (:form s-ast))))

  (let [v-ast (ast +)]
    (is (= :var (:op v-ast)))
    (is (= '+ (:form v-ast)))
    (is (= #'+ (:var v-ast)))
    (is (not (:assignable? v-ast))))

  (is (:assignable? (ast *warn-on-reflection*)))

  (let [mh-ast (ast foo/bar)]
    (is (= :maybe-host-form (:op mh-ast)))
    (is (= 'foo (:class mh-ast)))
    (is (= 'bar (:field mh-ast))))

  (let [mc-ast (ast bar)]
    (is (= :maybe-class (:op mc-ast)))
    (is (= 'bar (:class mc-ast))))

  (let [l-ast (ast (let [a 1] a))]
    (is (= :local (-> l-ast :body :ret :op)))
    (is (= :let (-> l-ast :body :ret :local))))

  (let [do-ast (ast (do 1 2 3))]
    (is (= 3 (-> do-ast :ret :form)))
    (is (= [1 2] (->> do-ast :statements (mapv :form))))
    (is (= :ctx/statement (-> do-ast :statements first :env :context))))

  (let [if-ast (ast (if 1 2 3))]
    (is (= [1 2 3] (->> if-ast ((juxt :test :then :else)) (mapv :form)))))

  (let [new-ast (ast (foo. 1 2))]
    (is (= 'foo (:class new-ast)))
    (is (= [1 2] (->> new-ast :args (mapv :form)))))

  (let [q-ast (:expr (ast '^{a b} [c d]))]
    (is (= :const (-> q-ast :meta :op)))
    (is (= :const (-> q-ast :op)))
    (is (= '{a b} (-> q-ast :meta :form)))
    (is (= '[c d] (-> q-ast :form))))

  (let [s-ast (ast (set! *warn-on-reflection* true))]
    (is (= :set! (:op s-ast)))
    (is (= #'*warn-on-reflection* (-> s-ast :target :var)))
    (is (= true (-> s-ast :val :form))))

  (let [t-ast (ast (try 0 (catch E1 e e) (catch E2 e 2) (finally 3)))]
    (is (= 0 (-> t-ast :body :ret :form)))
    (is (= 2 (-> t-ast :catches second :body :ret :form)))
    (is (= 'E1 (-> t-ast :catches first :class)))
    (is (= 'e (-> t-ast :catches first :local :name)))
    (is (= 3 (-> t-ast :finally :ret :form))))

  (let [lfn-ast (ast (letfn [(a [] (b)) (b [] (a))] a))]
    (is (= :letfn (-> lfn-ast :body :ret :local)))
    (is (= '#{a b} (->> lfn-ast :bindings (mapv :name) set))))

  (let [l-ast (ast (loop [x 1] (recur 2)))]
    (is (= :loop (-> l-ast :bindings first :local)))
    (is (= :ctx/return (-> l-ast :body :env :context))))

  (let [f-ast (ast (fn a ([y & x] [x y]) ([] a) ([z] z)))]
    (is (= 1 (-> f-ast :max-fixed-arity)) (:meta f-ast))
    (is (:variadic? f-ast))
    (is (= true (-> f-ast :methods first :variadic?))))

  (let [d-ast (ast (def ^{c d} a 1))]
    (is (= 'a (-> d-ast :name)))
    (is (= '{c d} (-> d-ast :var meta (dissoc :line :column :file))))
    (is (= (ns-resolve 'user 'a)
           (-> e1 deref :namespaces (get 'user) :mappings (get 'a)))))

  (let [hc-ast (ast (.foo bar baz))]
    (is (= :host-call (-> hc-ast :op)))
    (is (= 'foo (-> hc-ast :method))))

  (let [hf-ast (ast (.-foo bar))]
    (is (= :host-field (-> hf-ast :op)))
    (is (= 'foo (-> hf-ast :field))))

  (let [hi-ast (ast (.foo bar))]
    (is (= :host-interop (-> hi-ast :op)))
    (is (= 'foo (-> hi-ast :m-or-f))))

  (let [i-ast (ast (1 2))]
    (is (= :invoke (-> i-ast :op)))
    (is (= 1 (-> i-ast :fn :form)))
    (is (= [2] (->> i-ast :args (mapv :form))))))
