{:namespaces
 ({:source-url
   "https://github.com/clojure/tools.analyzer/blob/1384302fbca0ba129f326df9be7bba086f7bec29/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer-api.html",
   :name "clojure.tools.analyzer",
   :doc "Utilities for host-agnostic analysis of clojure forms"}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/f150829598db3f8bdee78fede823a117be246fdf/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.utils-api.html",
   :name "clojure.tools.analyzer.utils",
   :doc nil}),
 :vars
 ({:arglists ([form {:keys [context], :as env}]),
   :name "analyze",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/1384302fbca0ba129f326df9be7bba086f7bec29/src/main/clojure/clojure/tools/analyzer.clj#L17",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/1384302fbca0ba129f326df9be7bba086f7bec29/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/analyze",
   :doc
   "Given an environment, a map containing\n  -  :locals (mapping of names to lexical bindings),\n  -  :context (one of :statement, :expr or :return\nand form, returns an expression object (a map containing at least :form, :op and :env keys).\n  -  :namespaces\n  -  :ns",
   :var-type "function",
   :line 17,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([exprs env]),
   :name "analyze-block",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/1384302fbca0ba129f326df9be7bba086f7bec29/src/main/clojure/clojure/tools/analyzer.clj#L174",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/1384302fbca0ba129f326df9be7bba086f7bec29/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/analyze-block",
   :doc "returns {:statements .. :ret ..}",
   :var-type "function",
   :line 174,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([env]),
   :name "analyze-in-env",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/1384302fbca0ba129f326df9be7bba086f7bec29/src/main/clojure/clojure/tools/analyzer.clj#L45",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/1384302fbca0ba129f326df9be7bba086f7bec29/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/analyze-in-env",
   :doc
   "Given an env returns a function that when called with an argument\nanalyzes that argument in the specified env",
   :var-type "function",
   :line 45,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([form]),
   :name "classify",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/f150829598db3f8bdee78fede823a117be246fdf/src/main/clojure/clojure/tools/analyzer/utils.clj#L35",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/f150829598db3f8bdee78fede823a117be246fdf/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/classify",
   :doc "Returns a keyword describing the form type",
   :var-type "function",
   :line 35,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([env ctx]),
   :name "ctx",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/f150829598db3f8bdee78fede823a117be246fdf/src/main/clojure/clojure/tools/analyzer/utils.clj#L17",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/f150829598db3f8bdee78fede823a117be246fdf/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/ctx",
   :doc
   "Returns a copy of the passe environment with :context set to ctx",
   :var-type "function",
   :line 17,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"})}
