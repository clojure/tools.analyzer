(ns clojure.tools.analyzer.query-test
  (:refer-clojure :exclude [macroexpand-1])
  (:require [clojure.tools.analyzer.ast :refer :all]
            [clojure.test :refer [deftest is]]
            [clojure.tools.analyzer.core-test :refer [ast e]]
            [clojure.tools.analyzer.ast.query :refer [q]]
            [clojure.tools.analyzer.ast :as ast]
            [clojure.tools.analyzer.utils :refer [compile-if]]
            [clojure.tools.analyzer.passes.index-vector-nodes :refer [index-vector-nodes]]))

(def clojure-version-seven-query
  '[:find ?docstring
    :where
    [?def :op :def]
    [?def :init ?fn]
    [?fn :methods ?method]
    [?method :body ?body]
    [?body :statements ?statement]
    [?statement :val ?docstring]
    [?statement :type :string]
    [?statement :idx 0]])

(def clojure-version-eight-and-above-query
  '[:find ?docstring
    :where
    [?def :op :def]
    [?def :init ?fn]
    [?fn :expr ?expr]
    [?expr :methods ?method]
    [?method :body ?body]
    [?body :statements ?statement]
    [?statement :val ?docstring]
    [?statement :type :string]
    [?statement :idx 0]])

(compile-if (Class/forName "datomic.Datom")
 (deftest query
   (let [ast       (ast/prewalk (ast (defn x [] "misplaced docstring" 1))
                                index-vector-nodes)
         the-query (if (< (:minor *clojure-version*) 8)
                     clojure-version-seven-query
                     clojure-version-eight-and-above-query)]
     (is (= "misplaced docstring"
            (ffirst (q the-query [ast])))))))
