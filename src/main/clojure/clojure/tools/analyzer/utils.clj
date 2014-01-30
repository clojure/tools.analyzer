;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.utils
  (:refer-clojure :exclude [record?])
  (:import (clojure.lang IRecord IType IObj
                         IReference Var)
           java.util.regex.Pattern))

(defmacro update!
  "Shortrand for (set! x (f x a0 .. an))"
  [target f & args]
  (list 'set! target (list* f target args)))

(defn ctx
  "Returns a copy of the passed environment with :context set to ctx"
  [env ctx]
  (assoc env :context ctx))

(defn record? [x]
  (instance? IRecord x))
(defn type? [x]
  (instance? IType x))
(defn obj? [x]
  (instance? IObj x))
(defn reference? [x]
  (instance? IReference x))
(defn regex? [x]
  (instance? Pattern x))
(defn boolean? [x]
  (or (true? x) (false? x)))

(defn classify
  "Returns a keyword describing the form type"
  [form]
  (cond
   (nil? form)     :nil
   (boolean? form) :bool
   (keyword? form) :keyword
   (symbol? form)  :symbol
   (string? form)  :string
   (number? form)  :number
   (type? form)    :type
   (record? form)  :record
   (map? form)     :map
   (vector? form)  :vector
   (set? form)     :set
   (seq? form)     :seq
   (char? form)    :char
   (regex? form)   :regex
   (class? form)   :class
   (var? form)     :var
   :else           :unknown))

(defn private? [var]
  (:private (meta var)))
(defn macro? [var]
  (:macro (meta var)))
(defn constant? [var]
  (:const (meta var)))
(defn dynamic? [var]
  (or (:dynamic (meta var))
      (when (var? var)
        (.isDynamic ^Var var))))
(defn protocol-node? [var]
  (boolean (:protocol (meta var))))

(defn resolve-ns [ns-sym {:keys [ns namespaces]}]
  (when ns-sym
    (or (get-in @namespaces [ns :aliases ns-sym])
        (:ns (@namespaces ns-sym)))))

(defn resolve-var [sym {:keys [ns namespaces] :as env}]
  (when (symbol? sym)
    (let [name (-> sym name symbol)
          sym-ns (when-let [ns (namespace sym)]
                   (symbol ns))
          full-ns (resolve-ns sym-ns env)]
      (when (or (not sym-ns) full-ns)
        (-> (@namespaces (or full-ns ns)) :mappings (get name))))))

(defn arglist-for-arity [fn argc]
  (let [arglists (->> fn :arglists (sort-by count))
        arglist (->> arglists (filter #(= argc (count %))) first)
        last-arglist (last arglists)]
    (or arglist
        (when (and (some '#{&} last-arglist)
                   (>= argc (- (count last-arglist) 2)))
          last-arglist))))

(defn get-line [x env]
  (-> x meta :line))
(defn get-col [x env]
  (-> x meta :column))

(defn -source-info [x env]
  (merge
   (when-let [file (and (not= *file* "NO_SOURCE_FILE")
                        *file*)]
     {:file file})
   (when-let [line (get-line x env)]
     {:line line})
   (when-let [column (get-col x env)]
     {:column column})))

(defn source-info [{:keys [file line column]}]
  (merge {}
         (when file
           {:file file})
         (when line
           {:line line})
         (when column
           {:column column})))

(defn const-val [{:keys [op val expr]}]
  (if (= :quote op)
    (:val expr)
    val))

(defmacro compile-if
  [exp then & else]
  (if (try (eval exp)
           (catch Throwable _ false))
    `(do ~then)
    `(do ~@else)))
