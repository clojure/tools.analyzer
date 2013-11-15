;:   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.warn-earmuff
  (:require [clojure.tools.analyzer.utils :refer [dynamic?]]))

(defn warn-earmuff
  "Prints a warning to *err* if the AST node is a :def node and the
   var name contains earmuffs but the var is not marked dynamic"
  [{:keys [op name var] :as ast}]
  (let [name (str name)]
    (when (and (= :def op)
               (.startsWith name "*")
               (.endsWith name "*")
               (not (dynamic? var)))
      (binding [*out* *err*]
        (println "Warning:" name "not declared dynamic and this is not dynamically rebindable,"
                 "but its name suggests otherwise."
                 "Please either indicate ^:dynamic" name "or change the name"))))
  ast)
