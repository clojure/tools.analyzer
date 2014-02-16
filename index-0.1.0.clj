{:namespaces
 ({:source-url
   "https://github.com/clojure/tools.analyzer/blob/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer-api.html",
   :name "clojure.tools.analyzer",
   :doc
   "Analyzer for clojure code, host agnostic.\n\nEntry point:\n* analyze\n\nPlatform implementers must provide dynamic bindings for:\n* macroexpand-1\n* parse\n* create-var\n* var?\n\nSee clojure.tools.analyzer.core-test for an example on how to setup the analyzer."}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/c55f5cdc1a76ad04d4f6781762c38077d52a26b6/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.ast-api.html",
   :name "clojure.tools.analyzer.ast",
   :doc "Utilities for AST walking/updating"}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/87bc3a0a8faff84362e2cbd43e20774e869343fb/src/main/clojure/clojure/tools/analyzer/ast/query.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.ast.query-api.html",
   :name "clojure.tools.analyzer.ast.query",
   :doc "Utilities for querying tools.analyzer ASTs with Datomic"}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/add_binding_atom.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.add-binding-atom-api.html",
   :name "clojure.tools.analyzer.passes.add-binding-atom",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/e8c04cb75e4b3f997bea43cebd64353e7aa1c445/src/main/clojure/clojure/tools/analyzer/passes/collect.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.collect-api.html",
   :name "clojure.tools.analyzer.passes.collect",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/constant_lifter.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.constant-lifter-api.html",
   :name "clojure.tools.analyzer.passes.constant-lifter",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.elide-meta-api.html",
   :name "clojure.tools.analyzer.passes.elide-meta",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.emit-form-api.html",
   :name "clojure.tools.analyzer.passes.emit-form",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/index_vector_nodes.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.index-vector-nodes-api.html",
   :name "clojure.tools.analyzer.passes.index-vector-nodes",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/source_info.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.source-info-api.html",
   :name "clojure.tools.analyzer.passes.source-info",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/63bc13a86ed5c56b7dddfe207af0a914303c5ef6/src/main/clojure/clojure/tools/analyzer/passes/uniquify.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.uniquify-api.html",
   :name "clojure.tools.analyzer.passes.uniquify",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/warn_earmuff.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.warn-earmuff-api.html",
   :name "clojure.tools.analyzer.passes.warn-earmuff",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.utils-api.html",
   :name "clojure.tools.analyzer.utils",
   :doc nil}),
 :vars
 ({:file "src/main/clojure/clojure/tools/analyzer.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj#L26",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/-parse",
   :namespace "clojure.tools.analyzer",
   :line 26,
   :var-type "multimethod",
   :doc
   "Takes a form and an env map and dispatches on the head of the form, that is\na special form.",
   :name "-parse"}
  {:arglists ([form env]),
   :name "analyze",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj#L31",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/analyze",
   :doc
   "Given a form to analyze and an environment, a map containing:\n* :locals     a map from binding symbol to AST of the binding value\n* :context    a keyword describing the form's context, one of:\n ** :return     the form is in return position\n ** :statement  the return value of the form is not needed\n ** :expr       everything else\n* :ns         a symbol representing the current namespace of the form to be\n              analyzed, must be present in the :namespaces map\n* :namespaces an atom containing a map from namespace symbol to namespace map,\n              the namespace map contains the following keys:\n ** :mappings   a map of mappings of the namespace, symbol to var/class\n ** :aliases    a map of the aliases of the namespace, symbol to symbol\n ** :ns         a symbol representing the namespace\n\nreturns an AST for that form.\n\nEvery node in the AST is a map that is *guaranteed* to have the following keys:\n* :op   a keyword describing the AST node\n* :form the form represented by the AST node\n* :env  the environment map of the AST node\n\nAdditionaly if the AST node contains sub-nodes, it is guaranteed to have:\n* :children a vector of the keys of the AST node mapping to the sub-nodes,\n            ordered, when that makes sense\n\nIt is considered a node either the top-level map or a node that can be\nreached via :children; if a node contains a node-like map that is not reachable\nby :children, there's no guarantee that such a map will contain the guaranteed keys.",
   :var-type "function",
   :line 31,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([env]),
   :name "analyze-in-env",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj#L92",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/analyze-in-env",
   :doc
   "Takes an env map and returns a function that analyzes a form in that env",
   :var-type "function",
   :line 92,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([sym env]),
   :name "create-var",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj#L108",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/create-var",
   :doc "Creates a var for sym and returns it",
   :var-type "function",
   :line 108,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([]),
   :name "empty-env",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj#L81",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/empty-env",
   :doc "Returns an empty env",
   :var-type "function",
   :line 81,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([form env]),
   :name "macroexpand",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj#L193",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/macroexpand",
   :doc
   "Repeatedly calls macroexpand-1 on form until it no longer\nrepresents a macro form, then returns it.",
   :var-type "function",
   :line 193,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([form env]),
   :name "macroexpand-1",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj#L97",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/macroexpand-1",
   :doc
   "If form represents a macro form, returns its expansion,\nelse returns form.",
   :var-type "function",
   :line 97,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([[op & args] env]),
   :name "parse",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj#L103",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/parse",
   :doc "Multimethod that dispatches on op, should default to -parse",
   :var-type "function",
   :line 103,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:file "src/main/clojure/clojure/tools/analyzer.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj#L187",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/specials",
   :namespace "clojure.tools.analyzer",
   :line 187,
   :var-type "var",
   :doc "Set of special forms common to every clojure variant",
   :name "specials"}
  {:arglists ([obj]),
   :name "var?",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj#L113",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/14ed25f9f65fa6e2d5f7c8c93e3d10e6235099fa/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/var?",
   :doc
   "Returns true if obj represent a var form as returned by create-var",
   :var-type "function",
   :line 113,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([ast]),
   :name "ast->eav",
   :namespace "clojure.tools.analyzer.ast",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c55f5cdc1a76ad04d4f6781762c38077d52a26b6/src/main/clojure/clojure/tools/analyzer/ast.clj#L86",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c55f5cdc1a76ad04d4f6781762c38077d52a26b6/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.ast/ast->eav",
   :doc
   "Returns an EAV representation of the current AST that can be used by\nDatomic's Datalog.",
   :var-type "function",
   :line 86,
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj"}
  {:arglists ([ast]),
   :name "children",
   :namespace "clojure.tools.analyzer.ast",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c55f5cdc1a76ad04d4f6781762c38077d52a26b6/src/main/clojure/clojure/tools/analyzer/ast.clj#L32",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c55f5cdc1a76ad04d4f6781762c38077d52a26b6/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.ast/children",
   :doc
   "Return a vector of the children expression of the AST node, if it has any.\nThe children expressions are kept in order and flattened so that the returning\nvector contains only nodes and not vectors of nodes.",
   :var-type "function",
   :line 32,
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj"}
  {:arglists ([{:keys [children], :as ast}]),
   :name "children*",
   :namespace "clojure.tools.analyzer.ast",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c55f5cdc1a76ad04d4f6781762c38077d52a26b6/src/main/clojure/clojure/tools/analyzer/ast.clj#L24",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c55f5cdc1a76ad04d4f6781762c38077d52a26b6/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.ast/children*",
   :doc
   "Return a vector of the children expression of the AST node, if it has any.\nThe returned vector returns the childrens in the order as they appear in the\n:children field of the AST, and may be either a node or a vector of nodes.",
   :var-type "function",
   :line 24,
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj"}
  {:arglists ([& fns*]),
   :name "cycling",
   :namespace "clojure.tools.analyzer.ast",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c55f5cdc1a76ad04d4f6781762c38077d52a26b6/src/main/clojure/clojure/tools/analyzer/ast.clj#L12",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c55f5cdc1a76ad04d4f6781762c38077d52a26b6/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.ast/cycling",
   :doc
   "Combine the given passes in a single pass that will be repeatedly\napplied to the AST until applying it another time will have no effect",
   :var-type "function",
   :line 12,
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj"}
  {:arglists ([ast]),
   :name "nodes",
   :namespace "clojure.tools.analyzer.ast",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c55f5cdc1a76ad04d4f6781762c38077d52a26b6/src/main/clojure/clojure/tools/analyzer/ast.clj#L80",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c55f5cdc1a76ad04d4f6781762c38077d52a26b6/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.ast/nodes",
   :doc
   "Returns a lazy-seq of all the nodes in the given AST, in depth-first pre-order.",
   :var-type "function",
   :line 80,
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj"}
  {:arglists ([ast f] [ast f reversed?]),
   :name "postwalk",
   :namespace "clojure.tools.analyzer.ast",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c55f5cdc1a76ad04d4f6781762c38077d52a26b6/src/main/clojure/clojure/tools/analyzer/ast.clj#L73",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c55f5cdc1a76ad04d4f6781762c38077d52a26b6/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.ast/postwalk",
   :doc "Shorthand for (walk ast identity f reversed?)",
   :var-type "function",
   :line 73,
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj"}
  {:arglists ([ast f]),
   :name "prewalk",
   :namespace "clojure.tools.analyzer.ast",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c55f5cdc1a76ad04d4f6781762c38077d52a26b6/src/main/clojure/clojure/tools/analyzer/ast.clj#L68",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c55f5cdc1a76ad04d4f6781762c38077d52a26b6/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.ast/prewalk",
   :doc "Shorthand for (walk ast f identity)",
   :var-type "function",
   :line 68,
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj"}
  {:arglists ([ast f] [ast f fix]),
   :name "update-children",
   :namespace "clojure.tools.analyzer.ast",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c55f5cdc1a76ad04d4f6781762c38077d52a26b6/src/main/clojure/clojure/tools/analyzer/ast.clj#L40",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c55f5cdc1a76ad04d4f6781762c38077d52a26b6/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.ast/update-children",
   :doc
   "Applies `f` to the nodes in the AST nodes children.\nOptionally applies `fix` to the children before applying `f` to the\nchildren nodes and then applies `fix` to the update children.\nAn example of a useful `fix` function is `rseq`.",
   :var-type "function",
   :line 40,
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj"}
  {:arglists ([ast pre post] [ast pre post reversed?]),
   :name "walk",
   :namespace "clojure.tools.analyzer.ast",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c55f5cdc1a76ad04d4f6781762c38077d52a26b6/src/main/clojure/clojure/tools/analyzer/ast.clj#L57",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c55f5cdc1a76ad04d4f6781762c38077d52a26b6/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.ast/walk",
   :doc
   "Walk the ast applying pre when entering the nodes, and post when exiting.\nIf reversed? is not-nil, pre and post will be applied starting from the last\nchildren of the AST node to the first one.",
   :var-type "function",
   :line 57,
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj"}
  {:arglists ([asts]),
   :name "db",
   :namespace "clojure.tools.analyzer.ast.query",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/87bc3a0a8faff84362e2cbd43e20774e869343fb/src/main/clojure/clojure/tools/analyzer/ast/query.clj#L77",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/87bc3a0a8faff84362e2cbd43e20774e869343fb/src/main/clojure/clojure/tools/analyzer/ast/query.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.ast.query/db",
   :doc
   "Given a list of ASTs, returns a representation of those\nthat can be used as a database in a Datomic Datalog query",
   :var-type "function",
   :line 77,
   :file "src/main/clojure/clojure/tools/analyzer/ast/query.clj"}
  {:arglists ([query asts & inputs]),
   :name "q",
   :namespace "clojure.tools.analyzer.ast.query",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/87bc3a0a8faff84362e2cbd43e20774e869343fb/src/main/clojure/clojure/tools/analyzer/ast/query.clj#L83",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/87bc3a0a8faff84362e2cbd43e20774e869343fb/src/main/clojure/clojure/tools/analyzer/ast/query.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.ast.query/q",
   :doc
   "Execute a Datomic Datalog query against the ASTs.\nThe first input is always assumed to be an AST database, if more\nare required, it's required to call `db` on them.\n`unfold-expression-clauses` is automatically applied to the\nquery.",
   :var-type "function",
   :line 83,
   :file "src/main/clojure/clojure/tools/analyzer/ast/query.clj"}
  {:arglists ([query]),
   :name "query-map",
   :namespace "clojure.tools.analyzer.ast.query",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/87bc3a0a8faff84362e2cbd43e20774e869343fb/src/main/clojure/clojure/tools/analyzer/ast/query.clj#L14",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/87bc3a0a8faff84362e2cbd43e20774e869343fb/src/main/clojure/clojure/tools/analyzer/ast/query.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.ast.query/query-map",
   :doc
   "Transoforms a Datomic query from its vector representation to its map one.\nIf the given query is already in its map representation, the original query\nis returned.",
   :var-type "function",
   :line 14,
   :file "src/main/clojure/clojure/tools/analyzer/ast/query.clj"}
  {:arglists ([query]),
   :name "resolve-calls",
   :namespace "clojure.tools.analyzer.ast.query",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/87bc3a0a8faff84362e2cbd43e20774e869343fb/src/main/clojure/clojure/tools/analyzer/ast/query.clj#L59",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/87bc3a0a8faff84362e2cbd43e20774e869343fb/src/main/clojure/clojure/tools/analyzer/ast/query.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.ast.query/resolve-calls",
   :doc
   "Automatically replace fn name symbols in expression clauses with\ntheir namespace qualified one if the symbol can be resolved in the\ncurrent namespace.",
   :var-type "function",
   :line 59,
   :file "src/main/clojure/clojure/tools/analyzer/ast/query.clj"}
  {:arglists ([query]),
   :name "unfold-expression-clauses",
   :namespace "clojure.tools.analyzer.ast.query",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/87bc3a0a8faff84362e2cbd43e20774e869343fb/src/main/clojure/clojure/tools/analyzer/ast/query.clj#L29",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/87bc3a0a8faff84362e2cbd43e20774e869343fb/src/main/clojure/clojure/tools/analyzer/ast/query.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.ast.query/unfold-expression-clauses",
   :doc
   "Given a Datomic query, walk the :where clauses searching for\nexpression clauses with nested calls, unnesting those calls.\n\nE.g {:where [[(inc (dec ?foo)) ?bar] ..] ..} will be transformed in\n{:where [[(dec ?foo) ?1234] [(inc ?1234) ?bar] ..] ..}",
   :var-type "function",
   :line 29,
   :file "src/main/clojure/clojure/tools/analyzer/ast/query.clj"}
  {:arglists ([ast]),
   :name "add-binding-atom",
   :namespace "clojure.tools.analyzer.passes.add-binding-atom",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/add_binding_atom.clj#L26",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/add_binding_atom.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.add-binding-atom/add-binding-atom",
   :doc
   "Walks the AST and adds an atom-backed-map to every local binding,\nthe same atom will be shared between all occurences of that local.\n\nThe atom is put in the :atom field of the node.",
   :var-type "function",
   :line 26,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/add_binding_atom.clj"}
  {:arglists ([{:keys [what top-level?], :as opts}]),
   :name "collect",
   :namespace "clojure.tools.analyzer.passes.collect",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/e8c04cb75e4b3f997bea43cebd64353e7aa1c445/src/main/clojure/clojure/tools/analyzer/passes/collect.clj#L144",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/e8c04cb75e4b3f997bea43cebd64353e7aa1c445/src/main/clojure/clojure/tools/analyzer/passes/collect.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.collect/collect",
   :doc
   "Takes a map with:\n* :what        set of keywords describing what to collect, some of:\n  ** :constants     constant expressions\n  ** :closed-overs  closed over local bindings\n  ** :callsites     keyword and protocol callsites\n* :where       set of :op nodes where to attach collected info\n* :top-level?  if true attach collected info to the top-level node",
   :var-type "function",
   :line 144,
   :file "src/main/clojure/clojure/tools/analyzer/passes/collect.clj"}
  {:file
   "src/main/clojure/clojure/tools/analyzer/passes/constant_lifter.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/constant_lifter.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/constant_lifter.clj#L13",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.constant-lifter/constant-lift",
   :namespace "clojure.tools.analyzer.passes.constant-lifter",
   :line 13,
   :var-type "multimethod",
   :doc
   "If op is :vector/:set/:map, and every item of the collection is a literal\nand the collection ha no metadata or if op is :var and the var has :const\nmetadata, transform the node to an equivalent :const node.",
   :name "constant-lift"}
  {:arglists ([ast]),
   :name "elide-meta",
   :namespace "clojure.tools.analyzer.passes.elide-meta",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj#L46",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.elide-meta/elide-meta",
   :doc
   "If elides is not empty and the AST node contains metadata,\ndissoc all the keys in elides from the metadata.",
   :var-type "function",
   :line 46,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj"}
  {:name "elides",
   :namespace "clojure.tools.analyzer.passes.elide-meta",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj#L11",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.elide-meta/elides",
   :doc "Set of map keys to elide from metadata.",
   :var-type "var",
   :line 11,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj"}
  {:arglists ([ast]),
   :name "emit-form",
   :namespace "clojure.tools.analyzer.passes.emit-form",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj#L21",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.emit-form/emit-form",
   :doc "Return the form represented by the given AST",
   :var-type "function",
   :line 21,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj"}
  {:arglists ([ast]),
   :name "emit-hygienic-form",
   :namespace "clojure.tools.analyzer.passes.emit-form",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj#L26",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.emit-form/emit-hygienic-form",
   :doc "Return an hygienic form represented by the given AST",
   :var-type "function",
   :line 26,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj"}
  {:arglists ([ast]),
   :name "index-vector-nodes",
   :namespace "clojure.tools.analyzer.passes.index-vector-nodes",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/index_vector_nodes.clj#L11",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/index_vector_nodes.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.index-vector-nodes/index-vector-nodes",
   :doc
   "Adds an :idx attribute to nodes in vector children, representing the position\nof the node vector.",
   :var-type "function",
   :line 11,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/index_vector_nodes.clj"}
  {:arglists ([ast]),
   :name "source-info",
   :namespace "clojure.tools.analyzer.passes.source-info",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/source_info.clj#L12",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/source_info.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.source-info/source-info",
   :doc
   "Adds (when possible) :line, :column and :file info to the AST :env",
   :var-type "function",
   :line 12,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/source_info.clj"}
  {:arglists ([ast]),
   :name "uniquify-locals",
   :namespace "clojure.tools.analyzer.passes.uniquify",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/63bc13a86ed5c56b7dddfe207af0a914303c5ef6/src/main/clojure/clojure/tools/analyzer/passes/uniquify.clj#L81",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/63bc13a86ed5c56b7dddfe207af0a914303c5ef6/src/main/clojure/clojure/tools/analyzer/passes/uniquify.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.uniquify/uniquify-locals",
   :doc
   "Walks the AST performing alpha-conversion on local\nbindings' :name field",
   :var-type "function",
   :line 81,
   :file "src/main/clojure/clojure/tools/analyzer/passes/uniquify.clj"}
  {:arglists ([ast]),
   :name "warn-earmuff",
   :namespace "clojure.tools.analyzer.passes.warn-earmuff",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/warn_earmuff.clj#L12",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/49b163e2c56a84897a784b35db211549471f3c19/src/main/clojure/clojure/tools/analyzer/passes/warn_earmuff.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.warn-earmuff/warn-earmuff",
   :doc
   "Prints a warning to *err* if the AST node is a :def node and the\nvar name contains earmuffs but the var is not marked dynamic",
   :var-type "function",
   :line 12,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/warn_earmuff.clj"}
  {:arglists ([x]),
   :name "boolean?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj#L40",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/boolean?",
   :doc "Returns true if x is a boolean",
   :var-type "function",
   :line 40,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([form]),
   :name "classify",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj#L45",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/classify",
   :doc "Returns a keyword describing the form type",
   :var-type "function",
   :line 45,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([var]),
   :name "constant?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj#L75",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/constant?",
   :doc "Returns true if the var is a const",
   :var-type "function",
   :line 75,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([env ctx]),
   :name "ctx",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj#L15",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/ctx",
   :doc
   "Returns a copy of the passed environment with :context set to ctx",
   :var-type "function",
   :line 15,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([var]),
   :name "dynamic?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj#L79",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/dynamic?",
   :doc "Returns true if the var is dynamic",
   :var-type "function",
   :line 79,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([var]),
   :name "macro?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj#L71",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/macro?",
   :doc "Returns true if the var maps to a macro",
   :var-type "function",
   :line 71,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([x]),
   :name "obj?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj#L28",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/obj?",
   :doc "Returns true if x implements IObj",
   :var-type "function",
   :line 28,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([var]),
   :name "private?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj#L67",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/private?",
   :doc "Returns true if the var is private",
   :var-type "function",
   :line 67,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([var]),
   :name "protocol-node?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj#L85",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/protocol-node?",
   :doc "Returns true if the var maps to a protocol function",
   :var-type "function",
   :line 85,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([x]),
   :name "record?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj#L20",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/record?",
   :doc "Returns true if x is a record",
   :var-type "function",
   :line 20,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([x]),
   :name "reference?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj#L32",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/reference?",
   :doc "Returns true if x implements IReference",
   :var-type "function",
   :line 32,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([x]),
   :name "regex?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj#L36",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/regex?",
   :doc "Returns true if x is a regex",
   :var-type "function",
   :line 36,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([x]),
   :name "type?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj#L24",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/82196c07b3974f957253f6fc1390d0e8d695c769/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/type?",
   :doc "Returns true if x is a type",
   :var-type "function",
   :line 24,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"})}
