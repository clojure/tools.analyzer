;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.env
  (:refer-clojure :exclude [ensure]))

(def ^:dynamic *env* nil)

(defmacro with-env
  [env & body]
  `(let [env# ~env
         env# (cond
               (map? env#) (atom env#)
               (and (instance? clojure.lang.Atom env#)
                    (map? @env#)) env#
               :default (throw (IllegalArgumentException.
                                (str "global env must be a map or atom containing a map, not "
                                     (class env#)))))]
     (binding [*env* env#] ~@body)))

;; if *env* is not bound, bind it to env
(defmacro ensure
  [env & body]
  `(if *env*
     (do ~@body)
     (with-env ~env
       ~@body)))

(defn deref-env []
  (if *env*
    @*env*
    (throw (ex-info "global env not bound"))))
