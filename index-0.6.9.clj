{:namespaces
 ({:doc
   "Analyzer for clojure code, host agnostic.\n\nEntry point:\n* analyze\n\nPlatform implementers must provide dynamic bindings for:\n* macroexpand-1\n* parse\n* create-var\n* var?\n\nSetting up the global env is also required, see clojure.tools.analyzer.env\n\nSee clojure.tools.analyzer.core-test for an example on how to setup the analyzer.",
   :name "clojure.tools.analyzer",
   :wiki-url "http://clojure.github.io/tools.analyzer/index.html",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj"}
  {:doc "Utilities for AST walking/updating",
   :name "clojure.tools.analyzer.ast",
   :wiki-url
   "http://clojure.github.io/tools.analyzer/index.html#clojure.tools.analyzer.ast",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj"}
  {:doc "Utilities for querying tools.analyzer ASTs with Datomic",
   :name "clojure.tools.analyzer.ast.query",
   :wiki-url
   "http://clojure.github.io/tools.analyzer/index.html#clojure.tools.analyzer.ast.query",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/4625930565c53488dc94454ce2ee40853df24962/src/main/clojure/clojure/tools/analyzer/ast/query.clj"}
  {:doc nil,
   :name "clojure.tools.analyzer.env",
   :wiki-url
   "http://clojure.github.io/tools.analyzer/index.html#clojure.tools.analyzer.env",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/16abd6b3f3a85196c2addac42de4ff83519cf10f/src/main/clojure/clojure/tools/analyzer/env.clj"}
  {:doc "Utilities for pass scheduling",
   :name "clojure.tools.analyzer.passes",
   :wiki-url
   "http://clojure.github.io/tools.analyzer/index.html#clojure.tools.analyzer.passes",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/29c3db85bd96b1d24ea2a9c0cfc2fd05fe796336/src/main/clojure/clojure/tools/analyzer/passes.clj"}
  {:doc nil,
   :name "clojure.tools.analyzer.passes.add-binding-atom",
   :wiki-url
   "http://clojure.github.io/tools.analyzer/index.html#clojure.tools.analyzer.passes.add-binding-atom",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5dc7857ee354d99b012e32dc4890161800200493/src/main/clojure/clojure/tools/analyzer/passes/add_binding_atom.clj"}
  {:doc nil,
   :name "clojure.tools.analyzer.passes.collect-closed-overs",
   :wiki-url
   "http://clojure.github.io/tools.analyzer/index.html#clojure.tools.analyzer.passes.collect-closed-overs",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/b17311c9e2ef1700563665f8647e48c571f85011/src/main/clojure/clojure/tools/analyzer/passes/collect_closed_overs.clj"}
  {:doc nil,
   :name "clojure.tools.analyzer.passes.constant-lifter",
   :wiki-url
   "http://clojure.github.io/tools.analyzer/index.html#clojure.tools.analyzer.passes.constant-lifter",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5dc7857ee354d99b012e32dc4890161800200493/src/main/clojure/clojure/tools/analyzer/passes/constant_lifter.clj"}
  {:doc nil,
   :name "clojure.tools.analyzer.passes.elide-meta",
   :wiki-url
   "http://clojure.github.io/tools.analyzer/index.html#clojure.tools.analyzer.passes.elide-meta",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/54457278c2c20d2ccb2de71bb8e67b7b08dd12fb/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj"}
  {:doc nil,
   :name "clojure.tools.analyzer.passes.emit-form",
   :wiki-url
   "http://clojure.github.io/tools.analyzer/index.html#clojure.tools.analyzer.passes.emit-form",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/88b74a22c4a62b716aa7dd587539aea257bfa3c0/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj"}
  {:doc nil,
   :name "clojure.tools.analyzer.passes.index-vector-nodes",
   :wiki-url
   "http://clojure.github.io/tools.analyzer/index.html#clojure.tools.analyzer.passes.index-vector-nodes",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/35086cdeb46b239f0d2e086db0813a408e9e4e02/src/main/clojure/clojure/tools/analyzer/passes/index_vector_nodes.clj"}
  {:doc nil,
   :name "clojure.tools.analyzer.passes.source-info",
   :wiki-url
   "http://clojure.github.io/tools.analyzer/index.html#clojure.tools.analyzer.passes.source-info",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/88e3d8ca1e3b94cd8961d6993afa607d35097d34/src/main/clojure/clojure/tools/analyzer/passes/source_info.clj"}
  {:doc nil,
   :name "clojure.tools.analyzer.passes.trim",
   :wiki-url
   "http://clojure.github.io/tools.analyzer/index.html#clojure.tools.analyzer.passes.trim",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/8a95cd2cfc1abf7a48caf52c3871b61453427e76/src/main/clojure/clojure/tools/analyzer/passes/trim.clj"}
  {:doc nil,
   :name "clojure.tools.analyzer.passes.uniquify",
   :wiki-url
   "http://clojure.github.io/tools.analyzer/index.html#clojure.tools.analyzer.passes.uniquify",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5dc7857ee354d99b012e32dc4890161800200493/src/main/clojure/clojure/tools/analyzer/passes/uniquify.clj"}
  {:doc nil,
   :name "clojure.tools.analyzer.passes.warn-earmuff",
   :wiki-url
   "http://clojure.github.io/tools.analyzer/index.html#clojure.tools.analyzer.passes.warn-earmuff",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5dc7857ee354d99b012e32dc4890161800200493/src/main/clojure/clojure/tools/analyzer/passes/warn_earmuff.clj"}
  {:doc nil,
   :name "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer/index.html#clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj"}),
 :vars
 ({:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj",
   :name "-parse",
   :file "src/main/clojure/clojure/tools/analyzer.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj#L805",
   :line 805,
   :var-type "function",
   :arglists ([form env]),
   :doc
   "Takes a form and an env map and dispatches on the head of the form, that is\na special form.",
   :namespace "clojure.tools.analyzer",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer/-parse"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj",
   :name "analyze",
   :file "src/main/clojure/clojure/tools/analyzer.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj#L88",
   :line 88,
   :var-type "function",
   :arglists ([form env]),
   :doc
   "Given a form to analyze and an environment, a map containing:\n* :locals     a map from binding symbol to AST of the binding value\n* :context    a keyword describing the form's context from the :ctx/* hierarchy.\n ** :ctx/expr      the form is an expression: its value is used\n ** :ctx/return    the form is an expression in return position, derives :ctx/expr\n ** :ctx/statement the value of the form is not used\n* :ns         a symbol representing the current namespace of the form to be\n              analyzed\n\nreturns an AST for that form.\n\nEvery node in the AST is a map that is *guaranteed* to have the following keys:\n* :op   a keyword describing the AST node\n* :form the form represented by the AST node\n* :env  the environment map of the AST node\n\nAdditionaly if the AST node contains sub-nodes, it is guaranteed to have:\n* :children a vector of the keys of the AST node mapping to the sub-nodes,\n            ordered, when that makes sense\n\nIt is considered a node either the top-level node (marked with :top-level true)\nor a node that can be reached via :children; if a node contains a node-like\nmap that is not reachable by :children, there's no guarantee that such a map\nwill contain the guaranteed keys.",
   :namespace "clojure.tools.analyzer",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer/analyze"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj",
   :name "analyze-form",
   :file "src/main/clojure/clojure/tools/analyzer.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj#L40",
   :dynamic true,
   :line 40,
   :var-type "multimethod",
   :arglists nil,
   :doc
   "Like analyze, but does not mark the form with :top-level true",
   :namespace "clojure.tools.analyzer",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer/analyze-form"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj",
   :name "analyze-in-env",
   :file "src/main/clojure/clojure/tools/analyzer.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj#L124",
   :line 124,
   :var-type "function",
   :arglists ([env]),
   :doc
   "Takes an env map and returns a function that analyzes a form in that env",
   :namespace "clojure.tools.analyzer",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer/analyze-in-env"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj",
   :name "create-var",
   :file "src/main/clojure/clojure/tools/analyzer.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj#L140",
   :dynamic true,
   :line 140,
   :var-type "function",
   :arglists ([sym env]),
   :doc "Creates a var for sym and returns it",
   :namespace "clojure.tools.analyzer",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer/create-var"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj",
   :name "empty-env",
   :file "src/main/clojure/clojure/tools/analyzer.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj#L117",
   :line 117,
   :var-type "function",
   :arglists ([]),
   :doc "Returns an empty env",
   :namespace "clojure.tools.analyzer",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer/empty-env"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj",
   :name "macroexpand",
   :file "src/main/clojure/clojure/tools/analyzer.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj#L224",
   :line 224,
   :var-type "function",
   :arglists ([form env]),
   :doc
   "Repeatedly calls macroexpand-1 on form until it no longer\nrepresents a macro form, then returns it.",
   :namespace "clojure.tools.analyzer",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer/macroexpand"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj",
   :name "macroexpand-1",
   :file "src/main/clojure/clojure/tools/analyzer.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj#L129",
   :dynamic true,
   :line 129,
   :var-type "function",
   :arglists ([form env]),
   :doc
   "If form represents a macro form, returns its expansion,\nelse returns form.",
   :namespace "clojure.tools.analyzer",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer/macroexpand-1"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj",
   :name "parse",
   :file "src/main/clojure/clojure/tools/analyzer.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj#L135",
   :dynamic true,
   :line 135,
   :var-type "function",
   :arglists ([[op & args] env]),
   :doc "Multimethod that dispatches on op, should default to -parse",
   :namespace "clojure.tools.analyzer",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer/parse"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj",
   :name "specials",
   :file "src/main/clojure/clojure/tools/analyzer.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj#L218",
   :line 218,
   :var-type "var",
   :arglists nil,
   :doc "Set of special forms common to every clojure variant",
   :namespace "clojure.tools.analyzer",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer/specials"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj",
   :name "var?",
   :file "src/main/clojure/clojure/tools/analyzer.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/6909fec3655ac194d9253191ffa9f1ecb76dc336/src/main/clojure/clojure/tools/analyzer.clj#L145",
   :dynamic true,
   :line 145,
   :var-type "function",
   :arglists ([obj]),
   :doc
   "Returns true if obj represent a var form as returned by create-var",
   :namespace "clojure.tools.analyzer",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer/var?"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :name "ast->eav",
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj#L123",
   :line 123,
   :var-type "function",
   :arglists ([ast]),
   :doc
   "Returns an EAV representation of the current AST that can be used by\nDatomic's Datalog.",
   :namespace "clojure.tools.analyzer.ast",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.ast/ast->eav"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :name "children",
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj#L36",
   :line 36,
   :var-type "function",
   :arglists ([ast]),
   :doc
   "Return a vector of the children expression of the AST node, if it has any.\nThe children expressions are kept in order and flattened so that the returning\nvector contains only nodes and not vectors of nodes.",
   :namespace "clojure.tools.analyzer.ast",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.ast/children"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :name "children*",
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj#L26",
   :line 26,
   :var-type "function",
   :arglists ([{:keys [children], :as ast}]),
   :doc
   "Return a vector of vectors of the children node key and the children expression\nof the AST node, if it has any.\nThe returned vector returns the childrens in the order as they appear in the\n:children field of the AST, and the children expressions may be either a node\nor a vector of nodes.",
   :namespace "clojure.tools.analyzer.ast",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.ast/children*"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :name "cycling",
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj#L14",
   :line 14,
   :var-type "function",
   :arglists ([& fns*]),
   :doc
   "Combine the given passes in a single pass that will be applieed repeatedly\nto the AST until applying it another time will have no effect",
   :namespace "clojure.tools.analyzer.ast",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.ast/cycling"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :name "nodes",
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj#L117",
   :line 117,
   :var-type "function",
   :arglists ([ast]),
   :doc
   "Returns a lazy-seq of all the nodes in the given AST, in depth-first pre-order.",
   :namespace "clojure.tools.analyzer.ast",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.ast/nodes"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :name "postwalk",
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj#L110",
   :line 110,
   :var-type "function",
   :arglists ([ast f] [ast f reversed?]),
   :doc "Shorthand for (walk ast identity f reversed?)",
   :namespace "clojure.tools.analyzer.ast",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.ast/postwalk"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :name "prewalk",
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj#L105",
   :line 105,
   :var-type "function",
   :arglists ([ast f]),
   :doc "Shorthand for (walk ast f identity)",
   :namespace "clojure.tools.analyzer.ast",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.ast/prewalk"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :name "update-children",
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj#L75",
   :line 75,
   :var-type "function",
   :arglists ([ast f] [ast f reversed?]),
   :doc
   "Applies `f` to each AST children node, replacing it with the returned value.\nIf reversed? is not-nil, `pre` and `post` will be applied starting from the last\nchildren of the AST node to the first one.\nShort-circuits on reduced.",
   :namespace "clojure.tools.analyzer.ast",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.ast/update-children"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :name "update-children-reduced",
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj#L58",
   :line 58,
   :var-type "function",
   :arglists ([ast f] [ast f reversed?]),
   :doc
   "Like update-children but returns a reduced holding the AST if f short-circuited.",
   :namespace "clojure.tools.analyzer.ast",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.ast/update-children-reduced"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :name "walk",
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/fd763e6a06319679f933f7fb9bf29910a004b262/src/main/clojure/clojure/tools/analyzer/ast.clj#L84",
   :line 84,
   :var-type "function",
   :arglists ([ast pre post] [ast pre post reversed?]),
   :doc
   "Walk the ast applying `pre` when entering the nodes, and `post` when exiting.\nBoth functions must return a valid node since the returned value will replace\nthe node in the AST which was given as input to the function.\nIf reversed? is not-nil, `pre` and `post` will be applied starting from the last\nchildren of the AST node to the first one.\nShort-circuits on reduced.",
   :namespace "clojure.tools.analyzer.ast",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.ast/walk"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/4625930565c53488dc94454ce2ee40853df24962/src/main/clojure/clojure/tools/analyzer/ast/query.clj",
   :name "db",
   :file "src/main/clojure/clojure/tools/analyzer/ast/query.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/4625930565c53488dc94454ce2ee40853df24962/src/main/clojure/clojure/tools/analyzer/ast/query.clj#L74",
   :line 74,
   :var-type "function",
   :arglists ([asts]),
   :doc
   "Given a list of ASTs, returns a representation of those\nthat can be used as a database in a Datomic Datalog query",
   :namespace "clojure.tools.analyzer.ast.query",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.ast.query/db"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/4625930565c53488dc94454ce2ee40853df24962/src/main/clojure/clojure/tools/analyzer/ast/query.clj",
   :name "q",
   :file "src/main/clojure/clojure/tools/analyzer/ast/query.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/4625930565c53488dc94454ce2ee40853df24962/src/main/clojure/clojure/tools/analyzer/ast/query.clj#L80",
   :line 80,
   :var-type "function",
   :arglists ([query asts & inputs]),
   :doc
   "Execute a Datomic Datalog query against the ASTs.\nThe first input is always assumed to be an AST database, if more\nare required, it's required to call `db` on them.\n`unfold-expression-clauses` is automatically applied to the\nquery.",
   :namespace "clojure.tools.analyzer.ast.query",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.ast.query/q"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/4625930565c53488dc94454ce2ee40853df24962/src/main/clojure/clojure/tools/analyzer/ast/query.clj",
   :name "query-map",
   :file "src/main/clojure/clojure/tools/analyzer/ast/query.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/4625930565c53488dc94454ce2ee40853df24962/src/main/clojure/clojure/tools/analyzer/ast/query.clj#L14",
   :line 14,
   :var-type "function",
   :arglists ([query]),
   :doc
   "Transoforms a Datomic query from its vector representation to its map one.\nIf the given query is already in its map representation, the original query\nis returned.",
   :namespace "clojure.tools.analyzer.ast.query",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.ast.query/query-map"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/4625930565c53488dc94454ce2ee40853df24962/src/main/clojure/clojure/tools/analyzer/ast/query.clj",
   :name "resolve-calls",
   :file "src/main/clojure/clojure/tools/analyzer/ast/query.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/4625930565c53488dc94454ce2ee40853df24962/src/main/clojure/clojure/tools/analyzer/ast/query.clj#L56",
   :line 56,
   :var-type "function",
   :arglists ([query]),
   :doc
   "Automatically replace fn name symbols in expression clauses with\ntheir namespace qualified one if the symbol can be resolved in the\ncurrent namespace.",
   :namespace "clojure.tools.analyzer.ast.query",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.ast.query/resolve-calls"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/4625930565c53488dc94454ce2ee40853df24962/src/main/clojure/clojure/tools/analyzer/ast/query.clj",
   :name "unfold-expression-clauses",
   :file "src/main/clojure/clojure/tools/analyzer/ast/query.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/4625930565c53488dc94454ce2ee40853df24962/src/main/clojure/clojure/tools/analyzer/ast/query.clj#L28",
   :line 28,
   :var-type "function",
   :arglists ([query]),
   :doc
   "Given a Datomic query, walk the :where clauses searching for\nexpression clauses with nested calls, unnesting those calls.\n\nE.g {:where [[(inc (dec ?foo)) ?bar] ..] ..} will be transformed in\n{:where [[(dec ?foo) ?1234] [(inc ?1234) ?bar] ..] ..}",
   :namespace "clojure.tools.analyzer.ast.query",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.ast.query/unfold-expression-clauses"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/16abd6b3f3a85196c2addac42de4ff83519cf10f/src/main/clojure/clojure/tools/analyzer/env.clj",
   :name "*env*",
   :file "src/main/clojure/clojure/tools/analyzer/env.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/16abd6b3f3a85196c2addac42de4ff83519cf10f/src/main/clojure/clojure/tools/analyzer/env.clj#L12",
   :dynamic true,
   :line 12,
   :var-type "var",
   :arglists nil,
   :doc
   "Global env atom\nRequired options:\n * :namespaces an atom containing a map from namespace symbol to namespace map,\n   the namespace map contains at least the following keys:\n  ** :mappings a map of mappings of the namespace, symbol to var/class\n  ** :aliases a map of the aliases of the namespace, symbol to symbol\n  ** :ns a symbol representing the namespace",
   :namespace "clojure.tools.analyzer.env",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.env/*env*"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/16abd6b3f3a85196c2addac42de4ff83519cf10f/src/main/clojure/clojure/tools/analyzer/env.clj",
   :name "deref-env",
   :file "src/main/clojure/clojure/tools/analyzer/env.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/16abd6b3f3a85196c2addac42de4ff83519cf10f/src/main/clojure/clojure/tools/analyzer/env.clj#L44",
   :line 44,
   :var-type "function",
   :arglists ([]),
   :doc
   "Returns the value of the current global env if bound, otherwise\nthrows an exception.",
   :namespace "clojure.tools.analyzer.env",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.env/deref-env"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/16abd6b3f3a85196c2addac42de4ff83519cf10f/src/main/clojure/clojure/tools/analyzer/env.clj",
   :name "ensure",
   :file "src/main/clojure/clojure/tools/analyzer/env.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/16abd6b3f3a85196c2addac42de4ff83519cf10f/src/main/clojure/clojure/tools/analyzer/env.clj#L36",
   :line 36,
   :var-type "macro",
   :arglists ([env & body]),
   :doc
   "If *env* is not bound it binds it to env before executing the body",
   :namespace "clojure.tools.analyzer.env",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.env/ensure"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/16abd6b3f3a85196c2addac42de4ff83519cf10f/src/main/clojure/clojure/tools/analyzer/env.clj",
   :name "with-env",
   :file "src/main/clojure/clojure/tools/analyzer/env.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/16abd6b3f3a85196c2addac42de4ff83519cf10f/src/main/clojure/clojure/tools/analyzer/env.clj#L22",
   :line 22,
   :var-type "macro",
   :arglists ([env & body]),
   :doc "Binds the global env to env, then executes the body",
   :namespace "clojure.tools.analyzer.env",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.env/with-env"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/29c3db85bd96b1d24ea2a9c0cfc2fd05fe796336/src/main/clojure/clojure/tools/analyzer/passes.clj",
   :name "calculate-deps",
   :file "src/main/clojure/clojure/tools/analyzer/passes.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/29c3db85bd96b1d24ea2a9c0cfc2fd05fe796336/src/main/clojure/clojure/tools/analyzer/passes.clj#L46",
   :line 46,
   :var-type "function",
   :arglists ([passes]),
   :doc
   "Takes a map of pass-name -> pass-info and adds to each pass-info :dependencies and\n:dependants info, which also contain the transitive dependencies",
   :namespace "clojure.tools.analyzer.passes",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.passes/calculate-deps"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/29c3db85bd96b1d24ea2a9c0cfc2fd05fe796336/src/main/clojure/clojure/tools/analyzer/passes.clj",
   :name "desugar-deps",
   :file "src/main/clojure/clojure/tools/analyzer/passes.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/29c3db85bd96b1d24ea2a9c0cfc2fd05fe796336/src/main/clojure/clojure/tools/analyzer/passes.clj#L24",
   :line 24,
   :var-type "function",
   :arglists ([passes]),
   :doc
   "Takes a map of pass-name -> pass deps and puts the :after :affects and :before passes\nin the appropriate pass :depends",
   :namespace "clojure.tools.analyzer.passes",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.passes/desugar-deps"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/29c3db85bd96b1d24ea2a9c0cfc2fd05fe796336/src/main/clojure/clojure/tools/analyzer/passes.clj",
   :name "group",
   :file "src/main/clojure/clojure/tools/analyzer/passes.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/29c3db85bd96b1d24ea2a9c0cfc2fd05fe796336/src/main/clojure/clojure/tools/analyzer/passes.clj#L61",
   :line 61,
   :var-type "function",
   :arglists ([state]),
   :doc
   "Takes a scheduler state and returns a vector of three elements (or nil):\n* the :walk of the current group\n* a vector of consecutive passes that can be collapsed in a single pass (the current group)\n* the remaining scheduler state\n\nE.g. given:\n[{:walk :any .. } {:walk :pre ..} {:walk :post ..} {:walk :pre ..}]\nit will return:\n[:pre [{:walk :any ..} {:walk :pre ..}] [{:walk :post ..} {:walk :pre ..}]]",
   :namespace "clojure.tools.analyzer.passes",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.passes/group"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/29c3db85bd96b1d24ea2a9c0cfc2fd05fe796336/src/main/clojure/clojure/tools/analyzer/passes.clj",
   :name "schedule",
   :file "src/main/clojure/clojure/tools/analyzer/passes.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/29c3db85bd96b1d24ea2a9c0cfc2fd05fe796336/src/main/clojure/clojure/tools/analyzer/passes.clj#L172",
   :line 172,
   :var-type "function",
   :arglists ([passes & [opts]]),
   :doc
   "Takes a set of Vars that represent tools.analyzer passes and returns a function\nthat takes an AST and applies all the passes and their dependencies to the AST,\ntrying to compose together as many passes as possible to reduce the number of\nfull tree traversals.\n\nEach pass must have a :pass-info element in its Var's metadata and it must point\nto a map with the following parameters (:before, :after, :affects and :state are\noptional):\n* :after    a set of Vars, the passes that must be run before this pass\n* :before   a set of Vars, the passes that must be run after this pass\n* :depends  a set of Vars, the passes this pass depends on, implies :after\n* :walk     a keyword, one of:\n              - :none if the pass does its own tree walking and cannot be composed\n                      with other passes\n              - :post if the pass requires a postwalk and can be composed with other\n                      passes\n              - :pre  if the pass requires a prewalk and can be composed with other\n                      passes\n              - :any  if the pass can be composed with other passes in both a prewalk\n                      or a postwalk\n* :affects  a set of Vars, this pass must be the last in the same tree traversal that all\n            the specified passes must partecipate in\n            This pass must take a function as argument and return the actual pass, the\n            argument represents the reified tree traversal which the pass can use to\n            control a recursive traversal, implies :depends\n* :state    a no-arg function that should return an atom holding an init value that will be\n            passed as the first argument to the pass (the pass will thus take the ast\n            as the second parameter), the atom will be the same for the whole tree traversal\n            and thus can be used to preserve state across the traversal\nAn opts map might be provided, valid parameters:\n* :debug?   if true, returns a vector of the scheduled passes rather than the concrete\n            function",
   :namespace "clojure.tools.analyzer.passes",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.passes/schedule"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/5dc7857ee354d99b012e32dc4890161800200493/src/main/clojure/clojure/tools/analyzer/passes/add_binding_atom.clj",
   :name "add-binding-atom",
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/add_binding_atom.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5dc7857ee354d99b012e32dc4890161800200493/src/main/clojure/clojure/tools/analyzer/passes/add_binding_atom.clj#L13",
   :line 13,
   :var-type "function",
   :arglists ([ast] [state ast]),
   :doc
   "Adds an atom-backed-map to every local binding,the same\natom will be shared between all occurences of that local.\n\nThe atom is put in the :atom field of the node.",
   :namespace "clojure.tools.analyzer.passes.add-binding-atom",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.passes.add-binding-atom/add-binding-atom"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/b17311c9e2ef1700563665f8647e48c571f85011/src/main/clojure/clojure/tools/analyzer/passes/collect_closed_overs.clj",
   :name "collect-closed-overs",
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/collect_closed_overs.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/b17311c9e2ef1700563665f8647e48c571f85011/src/main/clojure/clojure/tools/analyzer/passes/collect_closed_overs.clj#L59",
   :line 59,
   :var-type "function",
   :arglists ([ast]),
   :doc
   "Attach closed-overs info to the AST as specified by the passes opts:\n* :where       set of :op nodes where to attach the closed-overs\n* :top-level?  if true attach closed-overs info to the top-level node\n\nThe info will be attached in the :closed-overs field of the AST node\nand will be a map of local name -> binding AST node",
   :namespace "clojure.tools.analyzer.passes.collect-closed-overs",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.passes.collect-closed-overs/collect-closed-overs"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/5dc7857ee354d99b012e32dc4890161800200493/src/main/clojure/clojure/tools/analyzer/passes/constant_lifter.clj",
   :name "constant-lift",
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/constant_lifter.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5dc7857ee354d99b012e32dc4890161800200493/src/main/clojure/clojure/tools/analyzer/passes/constant_lifter.clj#L12",
   :line 12,
   :var-type "multimethod",
   :arglists nil,
   :doc
   "If the node represents a collection with no metadata, and every item of that\ncollection is a literal, transform the node to an equivalent :const node.",
   :namespace "clojure.tools.analyzer.passes.constant-lifter",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.passes.constant-lifter/constant-lift"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/54457278c2c20d2ccb2de71bb8e67b7b08dd12fb/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj",
   :name "elide-meta",
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/54457278c2c20d2ccb2de71bb8e67b7b08dd12fb/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj#L79",
   :line 79,
   :var-type "function",
   :arglists ([ast]),
   :doc
   "If elides is not empty and the AST node contains metadata,\ndissoc all the keys in elides from the metadata.",
   :namespace "clojure.tools.analyzer.passes.elide-meta",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.passes.elide-meta/elide-meta"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/54457278c2c20d2ccb2de71bb8e67b7b08dd12fb/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj",
   :name "elides",
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/54457278c2c20d2ccb2de71bb8e67b7b08dd12fb/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj#L12",
   :dynamic true,
   :line 12,
   :var-type "var",
   :arglists nil,
   :doc
   "A map of op keywords to predicate IFns.\nThe predicate will be used to indicate what map keys should be elided on\nmetadata of nodes for that op.\n:all can be used to indicate what should be elided for every node with\nmetadata.\nDefaults to {:all (set (:elide-meta *compiler-options*))}",
   :namespace "clojure.tools.analyzer.passes.elide-meta",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.passes.elide-meta/elides"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/88b74a22c4a62b716aa7dd587539aea257bfa3c0/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj",
   :name "-emit-form*",
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/88b74a22c4a62b716aa7dd587539aea257bfa3c0/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj#L14",
   :dynamic true,
   :line 14,
   :var-type "function",
   :arglists ([{:keys [form], :as ast} opts]),
   :doc
   "Extension point for custom emit-form implementations, should be rebound\nto a multimethod with custom emit-form :opts.",
   :namespace "clojure.tools.analyzer.passes.emit-form",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.passes.emit-form/-emit-form*"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/88b74a22c4a62b716aa7dd587539aea257bfa3c0/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj",
   :name "emit-form",
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/88b74a22c4a62b716aa7dd587539aea257bfa3c0/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj#L24",
   :line 24,
   :var-type "function",
   :arglists ([ast] [ast opts]),
   :doc
   "Return the form represented by the given AST.\nOpts is a set of options, valid options are:\n * :hygienic",
   :namespace "clojure.tools.analyzer.passes.emit-form",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.passes.emit-form/emit-form"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/88b74a22c4a62b716aa7dd587539aea257bfa3c0/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj",
   :name "emit-hygienic-form",
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/88b74a22c4a62b716aa7dd587539aea257bfa3c0/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj#L32",
   :line 32,
   :var-type "function",
   :arglists ([ast]),
   :doc "Return an hygienic form represented by the given AST",
   :namespace "clojure.tools.analyzer.passes.emit-form",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.passes.emit-form/emit-hygienic-form"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/35086cdeb46b239f0d2e086db0813a408e9e4e02/src/main/clojure/clojure/tools/analyzer/passes/index_vector_nodes.clj",
   :name "index-vector-nodes",
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/index_vector_nodes.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/35086cdeb46b239f0d2e086db0813a408e9e4e02/src/main/clojure/clojure/tools/analyzer/passes/index_vector_nodes.clj#L11",
   :line 11,
   :var-type "function",
   :arglists ([ast]),
   :doc
   "Adds an :idx attribute to nodes in a vector children, representing the position\nof the node vector.",
   :namespace "clojure.tools.analyzer.passes.index-vector-nodes",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.passes.index-vector-nodes/index-vector-nodes"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/88e3d8ca1e3b94cd8961d6993afa607d35097d34/src/main/clojure/clojure/tools/analyzer/passes/source_info.clj",
   :name "source-info",
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/source_info.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/88e3d8ca1e3b94cd8961d6993afa607d35097d34/src/main/clojure/clojure/tools/analyzer/passes/source_info.clj#L17",
   :line 17,
   :var-type "function",
   :arglists ([ast]),
   :doc
   "Adds (when avaliable) :line, :column, :end-line, :end-column and :file info to the AST :env",
   :namespace "clojure.tools.analyzer.passes.source-info",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.passes.source-info/source-info"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/8a95cd2cfc1abf7a48caf52c3871b61453427e76/src/main/clojure/clojure/tools/analyzer/passes/trim.clj",
   :name "trim",
   :file "src/main/clojure/clojure/tools/analyzer/passes/trim.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/8a95cd2cfc1abf7a48caf52c3871b61453427e76/src/main/clojure/clojure/tools/analyzer/passes/trim.clj#L46",
   :line 46,
   :var-type "function",
   :arglists ([ast]),
   :doc "Trims the AST of unnecessary nodes, e.g. (do (do 1)) -> 1",
   :namespace "clojure.tools.analyzer.passes.trim",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.passes.trim/trim"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/5dc7857ee354d99b012e32dc4890161800200493/src/main/clojure/clojure/tools/analyzer/passes/uniquify.clj",
   :name "uniquify-locals",
   :file "src/main/clojure/clojure/tools/analyzer/passes/uniquify.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5dc7857ee354d99b012e32dc4890161800200493/src/main/clojure/clojure/tools/analyzer/passes/uniquify.clj#L85",
   :line 85,
   :var-type "function",
   :arglists ([ast]),
   :doc
   "Walks the AST performing alpha-conversion on the :name field\n of :local/:binding nodes, invalidates :local map in :env field\n\nPasses opts:\n* :uniquify/uniquify-env  If true, uniquifies the :env :locals map",
   :namespace "clojure.tools.analyzer.passes.uniquify",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.passes.uniquify/uniquify-locals"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/5dc7857ee354d99b012e32dc4890161800200493/src/main/clojure/clojure/tools/analyzer/passes/warn_earmuff.clj",
   :name "warn-earmuff",
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/warn_earmuff.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5dc7857ee354d99b012e32dc4890161800200493/src/main/clojure/clojure/tools/analyzer/passes/warn_earmuff.clj#L12",
   :line 12,
   :var-type "function",
   :arglists ([ast]),
   :doc
   "Prints a warning to *err* if the AST node is a :def node and the\nvar name contains earmuffs but the var is not marked dynamic",
   :namespace "clojure.tools.analyzer.passes.warn-earmuff",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.passes.warn-earmuff/warn-earmuff"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "-source-info",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L220",
   :line 220,
   :var-type "function",
   :arglists ([x env]),
   :doc "Returns the source-info of x",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/-source-info"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "arglist-for-arity",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L174",
   :line 174,
   :var-type "function",
   :arglists ([fn argc]),
   :doc "Takes a fn node and an argc and returns the matching arglist",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/arglist-for-arity"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "boolean?",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L96",
   :line 96,
   :var-type "function",
   :arglists ([x]),
   :doc "Returns true if x is a boolean",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/boolean?"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "butlast+last",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L35",
   :line 35,
   :var-type "function",
   :arglists ([s]),
   :doc
   "Returns same value as (juxt butlast last), but slightly more\nefficient since it only traverses the input sequence s once, not\ntwice.",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/butlast+last"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "classify",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L101",
   :line 101,
   :var-type "function",
   :arglists ([form]),
   :doc "Returns a keyword describing the form type",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/classify"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "const-val",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L229",
   :line 229,
   :var-type "function",
   :arglists ([{:keys [form val]}]),
   :doc
   "Returns the value of a constant node (either :quote or :const)",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/const-val"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "constant?",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L135",
   :line 135,
   :var-type "function",
   :arglists ([var] [var m]),
   :doc "Returns true if the var is a const",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/constant?"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "ctx",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L25",
   :line 25,
   :var-type "function",
   :arglists ([env ctx]),
   :doc
   "Returns a copy of the passed environment with :context set to ctx",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/ctx"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "dissoc-env",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L30",
   :line 30,
   :var-type "function",
   :arglists ([ast]),
   :doc "Dissocs :env from the ast",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/dissoc-env"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "dynamic?",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L141",
   :line 141,
   :var-type "function",
   :arglists ([var] [var m]),
   :doc "Returns true if the var is dynamic",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/dynamic?"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "into!",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L15",
   :line 15,
   :var-type "function",
   :arglists ([to from]),
   :doc "Like into, but for transients",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/into!"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "macro?",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L129",
   :line 129,
   :var-type "function",
   :arglists ([var] [var m]),
   :doc "Returns true if the var maps to a macro",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/macro?"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "mapv'",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L202",
   :line 202,
   :var-type "function",
   :arglists ([f v]),
   :doc "Like mapv, but short-circuits on reduced",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/mapv'"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "merge'",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L197",
   :line 197,
   :var-type "function",
   :arglists ([m & mms]),
   :doc "Like merge, but uses transients",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/merge'"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "mmerge",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L234",
   :line 234,
   :var-type "var",
   :arglists nil,
   :doc "Same as (fn [m1 m2] (merge-with merge m2 m1))",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/mmerge"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "obj?",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L71",
   :line 71,
   :var-type "function",
   :arglists ([x]),
   :doc "Returns true if x implements IObj",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/obj?"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "private?",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L123",
   :line 123,
   :var-type "function",
   :arglists ([var] [var m]),
   :doc "Returns true if the var is private",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/private?"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "protocol-node?",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L149",
   :line 149,
   :var-type "function",
   :arglists ([var] [var m]),
   :doc "Returns true if the var maps to a protocol function",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/protocol-node?"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "record?",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L61",
   :line 61,
   :var-type "function",
   :arglists ([x]),
   :doc "Returns true if x is a record",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/record?"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "reference?",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L76",
   :line 76,
   :var-type "function",
   :arglists ([x]),
   :doc "Returns true if x implements IReference",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/reference?"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "regex?",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L88",
   :line 88,
   :var-type "function",
   :arglists ([x]),
   :doc "Returns true if x is a regex",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/regex?"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "resolve-ns",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L155",
   :line 155,
   :var-type "function",
   :arglists ([ns-sym {:keys [ns]}]),
   :doc "Resolves the ns mapped by the given sym in the global env",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/resolve-ns"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "resolve-sym",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L163",
   :line 163,
   :var-type "function",
   :arglists ([sym {:keys [ns], :as env}]),
   :doc "Resolves the value mapped by the given sym in the global env",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/resolve-sym"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "rseqv",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L20",
   :line 20,
   :var-type "function",
   :arglists ([v]),
   :doc "Same as (comp vec rseq)",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/rseqv"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "select-keys'",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L185",
   :line 185,
   :var-type "function",
   :arglists ([map keyseq]),
   :doc
   "Like clojure.core/select-keys, but uses transients and doesn't preserve meta",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/select-keys'"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "source-info",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L214",
   :line 214,
   :var-type "function",
   :arglists ([m]),
   :doc "Returns the available source-info keys from a map",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/source-info"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "type?",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L66",
   :line 66,
   :var-type "function",
   :arglists ([x]),
   :doc "Returns true if x is a type",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/type?"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "update-keys",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L51",
   :line 51,
   :var-type "function",
   :arglists ([m f]),
   :doc "Applies f to all the keys in the map",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/update-keys"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "update-kv",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L56",
   :line 56,
   :var-type "function",
   :arglists ([m f]),
   :doc "Applies f to all the keys and vals in the map",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/update-kv"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :name "update-vals",
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c375596ca76f79d701132d75c4021aeb4a3d20d4/src/main/clojure/clojure/tools/analyzer/utils.clj#L46",
   :line 46,
   :var-type "function",
   :arglists ([m f]),
   :doc "Applies f to all the vals in the map",
   :namespace "clojure.tools.analyzer.utils",
   :wiki-url
   "http://clojure.github.io/tools.analyzer//index.html#clojure.tools.analyzer.utils/update-vals"})}
