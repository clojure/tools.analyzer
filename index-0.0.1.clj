{:namespaces
 ({:source-url
   "https://github.com/clojure/tools.analyzer/blob/e7589d5520749c2ba15dfa93263091dfb8e77907/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer-api.html",
   :name "clojure.tools.analyzer",
   :doc
   "Analyzer for clojure code, host agnostic.\n\nEntry point:\n* analyze\n\nPlatform implementers must provide dynamic bindings for:\n* macroexpand-1\n* create-var\n* parse\n\nSee clojure.tools.analyzer.core-test for an example on how to setup the analyzer."}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/382bd7a3f82fa796b23ef83e5ee1ac1442787ea2/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.utils-api.html",
   :name "clojure.tools.analyzer.utils",
   :doc nil}),
 :vars
 ({:file "src/main/clojure/clojure/tools/analyzer.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/e7589d5520749c2ba15dfa93263091dfb8e77907/src/main/clojure/clojure/tools/analyzer.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/e7589d5520749c2ba15dfa93263091dfb8e77907/src/main/clojure/clojure/tools/analyzer.clj#L25",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/-parse",
   :namespace "clojure.tools.analyzer",
   :line 25,
   :var-type "multimethod",
   :doc
   "Takes a form and an env map and dispatches on the head of the form, a special\nform.",
   :name "-parse"}
  {:arglists ([form {:keys [context], :as env}]),
   :name "analyze",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/e7589d5520749c2ba15dfa93263091dfb8e77907/src/main/clojure/clojure/tools/analyzer.clj#L30",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/e7589d5520749c2ba15dfa93263091dfb8e77907/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/analyze",
   :doc
   "Given a form to analyze and an environment, a map containing:\n* :locals     a map from binding symbol to AST of the binding value\n* :context    a keyword describing the form's context, one of:\n ** :return     the form is in return position\n ** :statement  the return value of the form is not needed\n ** :expr       everything else\n* :ns         a symbol representing the current namespace of the form to be\n              analyzed, must be present in the :namespaces map\n* :namespaces an atom containing a map from namespace symbol to namespace map,\n              the namespace map contains the following keys:\n ** :mappings   a map of mappings of the namespace, symbol to var\n ** :aliases    a map of the aliases of the namespace, symbol to symbol\n ** :ns         a symbol representing the namespace",
   :var-type "function",
   :line 30,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([env]),
   :name "analyze-in-env",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/e7589d5520749c2ba15dfa93263091dfb8e77907/src/main/clojure/clojure/tools/analyzer.clj#L73",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/e7589d5520749c2ba15dfa93263091dfb8e77907/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/analyze-in-env",
   :doc
   "Takes an env map and returns a function that analyzes a form in that env",
   :var-type "function",
   :line 73,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([sym env]),
   :name "create-var",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/e7589d5520749c2ba15dfa93263091dfb8e77907/src/main/clojure/clojure/tools/analyzer.clj#L84",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/e7589d5520749c2ba15dfa93263091dfb8e77907/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/create-var",
   :doc "Creates a var for sym and returns it",
   :var-type "function",
   :line 84,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([]),
   :name "empty-env",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/e7589d5520749c2ba15dfa93263091dfb8e77907/src/main/clojure/clojure/tools/analyzer.clj#L62",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/e7589d5520749c2ba15dfa93263091dfb8e77907/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/empty-env",
   :doc "Returns an empty env",
   :var-type "function",
   :line 62,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([form env]),
   :name "macroexpand-1",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/e7589d5520749c2ba15dfa93263091dfb8e77907/src/main/clojure/clojure/tools/analyzer.clj#L78",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/e7589d5520749c2ba15dfa93263091dfb8e77907/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/macroexpand-1",
   :doc
   "If form represents a macro form, returns its expansion,\nelse returns form.",
   :var-type "function",
   :line 78,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([[op & args] env]),
   :name "parse",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/e7589d5520749c2ba15dfa93263091dfb8e77907/src/main/clojure/clojure/tools/analyzer.clj#L89",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/e7589d5520749c2ba15dfa93263091dfb8e77907/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/parse",
   :doc "Multimethod that dispatches on op, should default to -parse",
   :var-type "function",
   :line 89,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([form]),
   :name "classify",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/382bd7a3f82fa796b23ef83e5ee1ac1442787ea2/src/main/clojure/clojure/tools/analyzer/utils.clj#L35",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/382bd7a3f82fa796b23ef83e5ee1ac1442787ea2/src/main/clojure/clojure/tools/analyzer/utils.clj",
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
   "https://github.com/clojure/tools.analyzer/blob/382bd7a3f82fa796b23ef83e5ee1ac1442787ea2/src/main/clojure/clojure/tools/analyzer/utils.clj#L17",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/382bd7a3f82fa796b23ef83e5ee1ac1442787ea2/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/ctx",
   :doc
   "Returns a copy of the passe environment with :context set to ctx",
   :var-type "function",
   :line 17,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"})}
