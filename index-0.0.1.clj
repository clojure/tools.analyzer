{:namespaces
 ({:source-url
   "https://github.com/clojure/tools.analyzer/blob/45cea4eafedc5ba5e8ba19e229653618123e70e3/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer-api.html",
   :name "clojure.tools.analyzer",
   :doc
   "Analyzer for clojure code, host agnostic.\n\nEntry point:\n* analyze\n\nPlatform implementers must provide dynamic bindings for:\n* macroexpand-1\n* create-var\n* parse\n\nSee clojure.tools.analyzer.core-test for an example on how to setup the analyzer."}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/47a681adae737943d24e169c8a379cf43c1f795e/src/main/clojure/clojure/tools/analyzer/passes.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes-api.html",
   :name "clojure.tools.analyzer.passes",
   :doc "Utilities for passes handling and for AST walking/updating"}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/382bd7a3f82fa796b23ef83e5ee1ac1442787ea2/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.utils-api.html",
   :name "clojure.tools.analyzer.utils",
   :doc nil}),
 :vars
 ({:file "src/main/clojure/clojure/tools/analyzer.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/45cea4eafedc5ba5e8ba19e229653618123e70e3/src/main/clojure/clojure/tools/analyzer.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/45cea4eafedc5ba5e8ba19e229653618123e70e3/src/main/clojure/clojure/tools/analyzer.clj#L25",
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
   "https://github.com/clojure/tools.analyzer/blob/45cea4eafedc5ba5e8ba19e229653618123e70e3/src/main/clojure/clojure/tools/analyzer.clj#L30",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/45cea4eafedc5ba5e8ba19e229653618123e70e3/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/analyze",
   :doc
   "Given a form to analyze and an environment, a map containing:\n* :locals     a map from binding symbol to AST of the binding value\n* :context    a keyword describing the form's context, one of:\n ** :return     the form is in return position\n ** :statement  the return value of the form is not needed\n ** :expr       everything else\n* :ns         a symbol representing the current namespace of the form to be\n              analyzed, must be present in the :namespaces map\n* :namespaces an atom containing a map from namespace symbol to namespace map,\n              the namespace map contains the following keys:\n ** :mappings   a map of mappings of the namespace, symbol to var\n ** :aliases    a map of the aliases of the namespace, symbol to symbol\n ** :ns         a symbol representing the namespace\nreturns an AST for that form.\n\nThe AST is a map that is *guaranteed* to have the following keys:\n* :op   a keyword describing the AST node\n* :form the form represented by the AST node\n* :env  the environment map of the AST node\n\nAdditionaly if the AST node contains sub-nodes, it is guaranteed to have:\n* :children a vector of the keys of the AST node mapping to the sub-nodes",
   :var-type "function",
   :line 30,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([env]),
   :name "analyze-in-env",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/45cea4eafedc5ba5e8ba19e229653618123e70e3/src/main/clojure/clojure/tools/analyzer.clj#L83",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/45cea4eafedc5ba5e8ba19e229653618123e70e3/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/analyze-in-env",
   :doc
   "Takes an env map and returns a function that analyzes a form in that env",
   :var-type "function",
   :line 83,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([sym env]),
   :name "create-var",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/45cea4eafedc5ba5e8ba19e229653618123e70e3/src/main/clojure/clojure/tools/analyzer.clj#L94",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/45cea4eafedc5ba5e8ba19e229653618123e70e3/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/create-var",
   :doc "Creates a var for sym and returns it",
   :var-type "function",
   :line 94,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([]),
   :name "empty-env",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/45cea4eafedc5ba5e8ba19e229653618123e70e3/src/main/clojure/clojure/tools/analyzer.clj#L72",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/45cea4eafedc5ba5e8ba19e229653618123e70e3/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/empty-env",
   :doc "Returns an empty env",
   :var-type "function",
   :line 72,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([form env]),
   :name "macroexpand-1",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/45cea4eafedc5ba5e8ba19e229653618123e70e3/src/main/clojure/clojure/tools/analyzer.clj#L88",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/45cea4eafedc5ba5e8ba19e229653618123e70e3/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/macroexpand-1",
   :doc
   "If form represents a macro form, returns its expansion,\nelse returns form.",
   :var-type "function",
   :line 88,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([[op & args] env]),
   :name "parse",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/45cea4eafedc5ba5e8ba19e229653618123e70e3/src/main/clojure/clojure/tools/analyzer.clj#L99",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/45cea4eafedc5ba5e8ba19e229653618123e70e3/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/parse",
   :doc "Multimethod that dispatches on op, should default to -parse",
   :var-type "function",
   :line 99,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([{:keys [children], :as ast}]),
   :name "children",
   :namespace "clojure.tools.analyzer.passes",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/47a681adae737943d24e169c8a379cf43c1f795e/src/main/clojure/clojure/tools/analyzer/passes.clj#L22",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/47a681adae737943d24e169c8a379cf43c1f795e/src/main/clojure/clojure/tools/analyzer/passes.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes/children",
   :doc
   "Return a vector of the children expression of the AST node, if it has any.\nThe returned vector is not flattened.",
   :var-type "function",
   :line 22,
   :file "src/main/clojure/clojure/tools/analyzer/passes.clj"}
  {:arglists ([& fns]),
   :name "cycling",
   :namespace "clojure.tools.analyzer.passes",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/47a681adae737943d24e169c8a379cf43c1f795e/src/main/clojure/clojure/tools/analyzer/passes.clj#L12",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/47a681adae737943d24e169c8a379cf43c1f795e/src/main/clojure/clojure/tools/analyzer/passes.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes/cycling",
   :doc
   "Combine the given passes in a single pass that will be repeatedly\napplied to the AST until applying it another time will have no effect",
   :var-type "function",
   :line 12,
   :file "src/main/clojure/clojure/tools/analyzer/passes.clj"}
  {:arglists ([ast f] [ast f reversed?]),
   :name "postwalk",
   :namespace "clojure.tools.analyzer.passes",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/47a681adae737943d24e169c8a379cf43c1f795e/src/main/clojure/clojure/tools/analyzer/passes.clj#L58",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/47a681adae737943d24e169c8a379cf43c1f795e/src/main/clojure/clojure/tools/analyzer/passes.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes/postwalk",
   :doc "Shortrand for (walk ast identity f reversed?)",
   :var-type "function",
   :line 58,
   :file "src/main/clojure/clojure/tools/analyzer/passes.clj"}
  {:arglists ([ast f]),
   :name "prewalk",
   :namespace "clojure.tools.analyzer.passes",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/47a681adae737943d24e169c8a379cf43c1f795e/src/main/clojure/clojure/tools/analyzer/passes.clj#L53",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/47a681adae737943d24e169c8a379cf43c1f795e/src/main/clojure/clojure/tools/analyzer/passes.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes/prewalk",
   :doc "Shortrand for (walk ast f identity)",
   :var-type "function",
   :line 53,
   :file "src/main/clojure/clojure/tools/analyzer/passes.clj"}
  {:arglists ([ast pre post] [ast pre post reversed?]),
   :name "walk",
   :namespace "clojure.tools.analyzer.passes",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/47a681adae737943d24e169c8a379cf43c1f795e/src/main/clojure/clojure/tools/analyzer/passes.clj#L40",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/47a681adae737943d24e169c8a379cf43c1f795e/src/main/clojure/clojure/tools/analyzer/passes.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes/walk",
   :doc
   "Walk the ast applying pre when entering the nodes, and post when exiting.\nIf reversed? is not-nil, pre and post will be applied starting from the last\nchildren of the AST node to the first one.",
   :var-type "function",
   :line 40,
   :file "src/main/clojure/clojure/tools/analyzer/passes.clj"}
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
