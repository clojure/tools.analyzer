(ns clojure.tools.analyzer.passes-test
  (:refer-clojure :exclude [macroexpand-1])
  (:require [clojure.tools.analyzer.passes :refer :all]
            [clojure.test :refer [deftest is]]))

(deftest passes-utils-test
  (let [ast {:foo [{:a 1} {:a 2}] :bar [{:a 3}] :children [:foo :bar]}]
    (is (= 2 (-> ast (prewalk (fn [ast] (if (:a ast)
                                        (update-in ast [:a] inc)
                                        ast)))
                :foo first :a)))
    (is (= 2 (-> ast (postwalk (fn [ast] (if (:a ast)
                                         (update-in ast [:a] inc)
                                         ast)))
                :foo first :a)))
    (is (= nil (-> ast (walk (fn [ast] (dissoc ast :a))
                          (fn [ast] (if (:a ast)
                                     (update-in ast [:a] inc)
                                     ast)))
                :foo first :a)))
    (is (= [3 2 1] (let [a (atom [])]
                     (-> ast (postwalk
                             (fn [ast] (when-let [el (:a ast)]
                                        (swap! a conj el))
                               ast) :reversed))
                     @a)))
    (is (= [[{:a 1} {:a 2}] [{:a 3}]] (children ast)))))
