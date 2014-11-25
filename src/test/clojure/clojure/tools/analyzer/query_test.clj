(ns clojure.tools.analyzer.query-test
  (:refer-clojure :exclude [macroexpand-1])
  (:require [clojure.tools.analyzer.ast :refer :all]
            [clojure.test :refer [deftest is]]
            [clojure.tools.analyzer.core-test :refer [ast e]]
            [clojure.tools.analyzer.ast.query :refer [q]]
            [clojure.tools.analyzer.ast :as ast]
            [clojure.tools.analyzer.utils :refer [compile-if]]
            [clojure.tools.analyzer.passes.index-vector-nodes :refer [index-vector-nodes]]))

(compile-if (Class/forName "datomic.Datom")
 (deftest query
   (let [ast (ast/prewalk (ast (defn x [] "misplaced docstring" 1))
                          index-vector-nodes)]
     (is (= "misplaced docstring"
            (ffirst
             (q '[:find ?docstring
                  :where
                  [?def :op :op/def]
                  [?def :init ?fn]
                  [?fn :methods ?method]
                  [?method :body ?body]
                  [?body :statements ?statement]
                  [?statement :val ?docstring]
                  [?statement :type :string]
                  [?statement :idx 0]]
                [ast])))))))
