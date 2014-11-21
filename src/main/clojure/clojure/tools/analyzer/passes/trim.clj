;; Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;; The use and distribution terms for this software are covered by the
;; Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;; which can be found in the file epl-v10.html at the root of this distribution.
;; By using this software in any fashion, you are agreeing to be bound by
;; the terms of this license.
;; You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.trim
  (:require [clojure.tools.analyzer.passes.elide-meta :refer [elide-meta]]))

;; TODO: implement :after/:before :most in the pass scheduler
(defmulti trim
  "EXPERIMENTAL -- DON'T USE
   Trims the AST of unnecessary nodes, e.g. (do (do 1)) -> 1"
  {:pass-info {:walk :none :depends #{} :after #{#'elide-meta :most}}}
  :op)

(defmethod trim :default [ast] ast)

;; TODO: some outer node fields like :tag win over the inner node
;;       ones, others like :o-tag don't..
;;       how to handle this without hardcoding the fields?

(defmethod trim :do
  [{:keys [statements ret] :as ast}]
  (if (or (and (every? :literal? statements)
               (:literal? ret))
          (empty? statements))
    (into (dissoc ast :children :statements :ret) ret)
    ast))

;; TODO: letfn/loop
(defmethod trim :let
  [{:keys [bindings body] :as ast}]
  (if (and (every? (comp :literal? :init) bindings)
           (:literal? body))
    (into (dissoc ast :children :bindings :body) body)
    ast))
