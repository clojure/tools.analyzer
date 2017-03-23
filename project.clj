(defproject org.clojure/tools.analyzer "0.6.8-SNAPSHOT"
  :description "An analyzer for Clojure code, written in Clojure and producing AST in EDN."
  :url "https://github.com/clojure/tools.analyzer"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths ["src/main/clojure"]
  :test-paths ["src/test/clojure"]
  :dependencies [[org.clojure/clojure "1.9.0-master-SNAPSHOT"]
                 [com.datomic/datomic-free "0.9.5327" :scope "provided" :exclusions [joda-time]]]
  :repositories [["sonatype" "http://oss.sonatype.org/content/repositories/releases"]
                 ["snapshots" "http://oss.sonatype.org/content/repositories/snapshots"]])
