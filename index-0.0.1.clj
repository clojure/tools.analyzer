{:namespaces
 ({:source-url
   "https://github.com/clojure/tools.analyzer/blob/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer-api.html",
   :name "clojure.tools.analyzer",
   :doc
   "Analyzer for clojure code, host agnostic.\n\nEntry point:\n* analyze\n\nPlatform implementers must provide dynamic bindings for:\n* macroexpand-1\n* parse\n* create-var\n* var?\n\nSee clojure.tools.analyzer.core-test for an example on how to setup the analyzer."}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.ast-api.html",
   :name "clojure.tools.analyzer.ast",
   :doc "Utilities for AST walking/updating"}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/passes/add_binding_atom.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.add-binding-atom-api.html",
   :name "clojure.tools.analyzer.passes.add-binding-atom",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/adaff4f9d6d386a6a26bb88d984313125cb4bb86/src/main/clojure/clojure/tools/analyzer/passes/collect.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.collect-api.html",
   :name "clojure.tools.analyzer.passes.collect",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/d2c9a64f7c546b287d521efc405d6b53c78a6212/src/main/clojure/clojure/tools/analyzer/passes/constant_lifter.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.constant-lifter-api.html",
   :name "clojure.tools.analyzer.passes.constant-lifter",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/0cf008c5ac5a343c58813d0c9f6b7951ef9347d1/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.elide-meta-api.html",
   :name "clojure.tools.analyzer.passes.elide-meta",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/cc7213301553ea58253ea5c57b0f6239f8d7256f/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.emit-form-api.html",
   :name "clojure.tools.analyzer.passes.emit-form",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/0cf008c5ac5a343c58813d0c9f6b7951ef9347d1/src/main/clojure/clojure/tools/analyzer/passes/source_info.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.source-info-api.html",
   :name "clojure.tools.analyzer.passes.source-info",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/6a92e32160dc49529fc1c41f675db73e42228007/src/main/clojure/clojure/tools/analyzer/passes/trim_do.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.trim-do-api.html",
   :name "clojure.tools.analyzer.passes.trim-do",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/passes/uniquify.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.uniquify-api.html",
   :name "clojure.tools.analyzer.passes.uniquify",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/2cfa02ed7fe23f36c373c9ff0fa5eb8d77b48038/src/main/clojure/clojure/tools/analyzer/passes/warn_earmuff.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.warn-earmuff-api.html",
   :name "clojure.tools.analyzer.passes.warn-earmuff",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/c7b8a10307ffa02fac6bfe2a41a02c51e1d78aec/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.utils-api.html",
   :name "clojure.tools.analyzer.utils",
   :doc nil}),
 :vars
 ({:file "src/main/clojure/clojure/tools/analyzer.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj#L26",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/-parse",
   :namespace "clojure.tools.analyzer",
   :line 26,
   :var-type "multimethod",
   :doc
   "Takes a form and an env map and dispatches on the head of the form, a special\nform.",
   :name "-parse"}
  {:arglists ([form {:keys [context], :as env}]),
   :name "analyze",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj#L31",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/analyze",
   :doc
   "Given a form to analyze and an environment, a map containing:\n* :locals     a map from binding symbol to AST of the binding value\n* :context    a keyword describing the form's context, one of:\n ** :return     the form is in return position\n ** :statement  the return value of the form is not needed\n ** :expr       everything else\n* :ns         a symbol representing the current namespace of the form to be\n              analyzed, must be present in the :namespaces map\n* :namespaces an atom containing a map from namespace symbol to namespace map,\n              the namespace map contains the following keys:\n ** :mappings   a map of mappings of the namespace, symbol to var\n ** :aliases    a map of the aliases of the namespace, symbol to symbol\n ** :ns         a symbol representing the namespace\nreturns an AST for that form.\n\nThe AST is a map that is *guaranteed* to have the following keys:\n* :op   a keyword describing the AST node\n* :form the form represented by the AST node\n* :env  the environment map of the AST node\n\nAdditionaly if the AST node contains sub-nodes, it is guaranteed to have:\n* :children a vector of the keys of the AST node mapping to the sub-nodes",
   :var-type "function",
   :line 31,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([env]),
   :name "analyze-in-env",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj#L84",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/analyze-in-env",
   :doc
   "Takes an env map and returns a function that analyzes a form in that env",
   :var-type "function",
   :line 84,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([sym env]),
   :name "create-var",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj#L100",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/create-var",
   :doc "Creates a var for sym and returns it",
   :var-type "function",
   :line 100,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([]),
   :name "empty-env",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj#L73",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/empty-env",
   :doc "Returns an empty env",
   :var-type "function",
   :line 73,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([form env]),
   :name "macroexpand",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj#L179",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/macroexpand",
   :doc
   "Repeatedly calls macroexpand-1 on form until it no longer\nrepresents a macro form, then returns it.",
   :var-type "function",
   :line 179,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([form env]),
   :name "macroexpand-1",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj#L89",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/macroexpand-1",
   :doc
   "If form represents a macro form, returns its expansion,\nelse returns form.",
   :var-type "function",
   :line 89,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([[op & args] env]),
   :name "parse",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj#L95",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/parse",
   :doc "Multimethod that dispatches on op, should default to -parse",
   :var-type "function",
   :line 95,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:file "src/main/clojure/clojure/tools/analyzer.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj#L173",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/specials",
   :namespace "clojure.tools.analyzer",
   :line 173,
   :var-type "var",
   :doc "Set of special forms common to every clojure variant",
   :name "specials"}
  {:arglists ([obj]),
   :name "var?",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj#L105",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/5c31e2058369c230b493e671caa48be741919b71/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/var?",
   :doc
   "Returns true if obj represent a var form as returned by create-var",
   :var-type "function",
   :line 105,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([ast]),
   :name "children",
   :namespace "clojure.tools.analyzer.ast",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/ast.clj#L32",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/ast.clj",
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
   "https://github.com/clojure/tools.analyzer/blob/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/ast.clj#L24",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/ast.clj",
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
   "https://github.com/clojure/tools.analyzer/blob/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/ast.clj#L12",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/ast.clj",
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
   "https://github.com/clojure/tools.analyzer/blob/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/ast.clj#L78",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.ast/nodes",
   :doc
   "Returns a lazy-seq of all the nodes in the given AST, in depth-first pre-order.",
   :var-type "function",
   :line 78,
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj"}
  {:arglists ([ast f] [ast f reversed?]),
   :name "postwalk",
   :namespace "clojure.tools.analyzer.ast",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/ast.clj#L71",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.ast/postwalk",
   :doc "Shorthand for (walk ast identity f reversed?)",
   :var-type "function",
   :line 71,
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj"}
  {:arglists ([ast f]),
   :name "prewalk",
   :namespace "clojure.tools.analyzer.ast",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/ast.clj#L66",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.ast/prewalk",
   :doc "Shorthand for (walk ast f identity)",
   :var-type "function",
   :line 66,
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj"}
  {:arglists ([ast f] [ast f fix]),
   :name "update-children",
   :namespace "clojure.tools.analyzer.ast",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/ast.clj#L40",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/ast.clj",
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
   "https://github.com/clojure/tools.analyzer/blob/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/ast.clj#L55",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/ast.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.ast/walk",
   :doc
   "Walk the ast applying pre when entering the nodes, and post when exiting.\nIf reversed? is not-nil, pre and post will be applied starting from the last\nchildren of the AST node to the first one.",
   :var-type "function",
   :line 55,
   :file "src/main/clojure/clojure/tools/analyzer/ast.clj"}
  {:arglists ([ast]),
   :name "add-binding-atom",
   :namespace "clojure.tools.analyzer.passes.add-binding-atom",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/passes/add_binding_atom.clj#L30",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/passes/add_binding_atom.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.add-binding-atom/add-binding-atom",
   :doc
   "Walks the AST and adds an atom-backed-map to every local binding,\nthe same atom will be shared between all occurences of that local.\n\nThe atom is put in the :atom field of the node.",
   :var-type "function",
   :line 30,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/add_binding_atom.clj"}
  {:arglists ([{:keys [what where top-level?]}]),
   :name "collect",
   :namespace "clojure.tools.analyzer.passes.collect",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/adaff4f9d6d386a6a26bb88d984313125cb4bb86/src/main/clojure/clojure/tools/analyzer/passes/collect.clj#L93",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/adaff4f9d6d386a6a26bb88d984313125cb4bb86/src/main/clojure/clojure/tools/analyzer/passes/collect.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.collect/collect",
   :doc
   "Takes a map with:\n* :what        set of keywords describing what to collect, some of:\n  ** :constants     constant expressions\n  ** :closed-overs  closed over local bindings\n  ** :callsites     keyword and protocol callsites\n* :where       set of :op nodes where to attach collected info\n* :top-level?  if true attach collected info to the top-level node",
   :var-type "function",
   :line 93,
   :file "src/main/clojure/clojure/tools/analyzer/passes/collect.clj"}
  {:file
   "src/main/clojure/clojure/tools/analyzer/passes/constant_lifter.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d2c9a64f7c546b287d521efc405d6b53c78a6212/src/main/clojure/clojure/tools/analyzer/passes/constant_lifter.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d2c9a64f7c546b287d521efc405d6b53c78a6212/src/main/clojure/clojure/tools/analyzer/passes/constant_lifter.clj#L13",
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
   "https://github.com/clojure/tools.analyzer/blob/0cf008c5ac5a343c58813d0c9f6b7951ef9347d1/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj#L52",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/0cf008c5ac5a343c58813d0c9f6b7951ef9347d1/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.elide-meta/elide-meta",
   :doc
   "If elides is not empty and the AST node contains metadata,\ndissoc all the keys in elides from the metadata.",
   :var-type "function",
   :line 52,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj"}
  {:name "elides",
   :namespace "clojure.tools.analyzer.passes.elide-meta",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/0cf008c5ac5a343c58813d0c9f6b7951ef9347d1/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj#L11",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/0cf008c5ac5a343c58813d0c9f6b7951ef9347d1/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj",
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
   "https://github.com/clojure/tools.analyzer/blob/cc7213301553ea58253ea5c57b0f6239f8d7256f/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj#L15",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/cc7213301553ea58253ea5c57b0f6239f8d7256f/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.emit-form/emit-form",
   :doc "Return the form represented by the given AST",
   :var-type "function",
   :line 15,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj"}
  {:arglists ([ast]),
   :name "emit-hygienic-form",
   :namespace "clojure.tools.analyzer.passes.emit-form",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/cc7213301553ea58253ea5c57b0f6239f8d7256f/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj#L20",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/cc7213301553ea58253ea5c57b0f6239f8d7256f/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.emit-form/emit-hygienic-form",
   :doc "Return an hygienic form represented by the given AST",
   :var-type "function",
   :line 20,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj"}
  {:arglists ([{:keys [form env], :as ast}]),
   :name "source-info",
   :namespace "clojure.tools.analyzer.passes.source-info",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/0cf008c5ac5a343c58813d0c9f6b7951ef9347d1/src/main/clojure/clojure/tools/analyzer/passes/source_info.clj#L12",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/0cf008c5ac5a343c58813d0c9f6b7951ef9347d1/src/main/clojure/clojure/tools/analyzer/passes/source_info.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.source-info/source-info",
   :doc
   "Adds (when possible) :line, :column and :file info to the AST :env",
   :var-type "function",
   :line 12,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/source_info.clj"}
  {:arglists ([{:keys [op ret statements], :as ast}]),
   :name "trim-do",
   :namespace "clojure.tools.analyzer.passes.trim-do",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/6a92e32160dc49529fc1c41f675db73e42228007/src/main/clojure/clojure/tools/analyzer/passes/trim_do.clj#L11",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/6a92e32160dc49529fc1c41f675db73e42228007/src/main/clojure/clojure/tools/analyzer/passes/trim_do.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.trim-do/trim-do",
   :doc
   "Replaces :do nodes with no :statements with their :ret expression",
   :var-type "function",
   :line 11,
   :file "src/main/clojure/clojure/tools/analyzer/passes/trim_do.clj"}
  {:arglists ([ast]),
   :name "uniquify-locals",
   :namespace "clojure.tools.analyzer.passes.uniquify",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/passes/uniquify.clj#L76",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/e75ad977e8883ebb99d3c4992134ab0d4c4c17c3/src/main/clojure/clojure/tools/analyzer/passes/uniquify.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.uniquify/uniquify-locals",
   :doc
   "Walks the AST performing alpha-conversion on local\nbindings' :name field",
   :var-type "function",
   :line 76,
   :file "src/main/clojure/clojure/tools/analyzer/passes/uniquify.clj"}
  {:arglists ([{:keys [op name var], :as ast}]),
   :name "warn-earmuff",
   :namespace "clojure.tools.analyzer.passes.warn-earmuff",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/2cfa02ed7fe23f36c373c9ff0fa5eb8d77b48038/src/main/clojure/clojure/tools/analyzer/passes/warn_earmuff.clj#L12",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/2cfa02ed7fe23f36c373c9ff0fa5eb8d77b48038/src/main/clojure/clojure/tools/analyzer/passes/warn_earmuff.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.warn-earmuff/warn-earmuff",
   :doc
   "Prints a warning to *err* if the AST node is a :def node and the\nvar name contains earmuffs but the var is not marked dynamic",
   :var-type "function",
   :line 12,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/warn_earmuff.clj"}
  {:arglists ([form]),
   :name "classify",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c7b8a10307ffa02fac6bfe2a41a02c51e1d78aec/src/main/clojure/clojure/tools/analyzer/utils.clj#L37",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c7b8a10307ffa02fac6bfe2a41a02c51e1d78aec/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/classify",
   :doc "Returns a keyword describing the form type",
   :var-type "function",
   :line 37,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([env ctx]),
   :name "ctx",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c7b8a10307ffa02fac6bfe2a41a02c51e1d78aec/src/main/clojure/clojure/tools/analyzer/utils.clj#L19",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c7b8a10307ffa02fac6bfe2a41a02c51e1d78aec/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/ctx",
   :doc
   "Returns a copy of the passed environment with :context set to ctx",
   :var-type "function",
   :line 19,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([target f & args]),
   :name "update!",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/c7b8a10307ffa02fac6bfe2a41a02c51e1d78aec/src/main/clojure/clojure/tools/analyzer/utils.clj#L14",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/c7b8a10307ffa02fac6bfe2a41a02c51e1d78aec/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/update!",
   :doc "Shortrand for (set! x (f x a0 .. an))",
   :var-type "macro",
   :line 14,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"})}
