;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.trim-do)

(defn trim-do
  "Replaces :do nodes with no :statements with their :ret expression"
  [{:keys [op ret statements] :as ast}]
  (if (and (= :do op)
           (empty? statements))
    ret
    ast))
