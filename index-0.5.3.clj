{:namespaces
 ({:source-url
   "https://github.com/clojure/tools.analyzer/blob/5fe8d5d67d3ee64babe4e18fa2de122e3853f07c/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer-api.html",
   :name "clojure.tools.analyzer",
   :doc
   "Analyzer for clojure code, host agnostic.\n\nEntry point:\n* analyze\n\nPlatform implementers must provide dynamic bindings for:\n* macroexpand-1\n* parse\n* create-var\n* var?\n\nSetting up the global env is also required, see clojure.tools.analyzer.env\n\nSee clojure.tools.analyzer.core-test for an example on how to setup the analyzer."}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/0bda3061cb95162feafb94a288422ae18767b07a/src/main/clojure/clojure/tools/analyzer/ast.clj",
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
   "https://github.com/clojure/tools.analyzer/blob/16abd6b3f3a85196c2addac42de4ff83519cf10f/src/main/clojure/clojure/tools/analyzer/env.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.env-api.html",
   :name "clojure.tools.analyzer.env",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/b4957158301682c10537738869a90f830705908f/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.elide-meta-api.html",
   :name "clojure.tools.analyzer.passes.elide-meta",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/aaf32c60b016770c5cdb76e44721a8897caf75da/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.emit-form-api.html",
   :name "clojure.tools.analyzer.passes.emit-form",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/fba761428d27ce927c5d5237778dfd0162376c62/src/main/clojure/clojure/tools/analyzer/passes/index_vector_nodes.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.index-vector-nodes-api.html",
   :name "clojure.tools.analyzer.passes.index-vector-nodes",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/fba761428d27ce927c5d5237778dfd0162376c62/src/main/clojure/clojure/tools/analyzer/passes/trim.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.trim-api.html",
   :name "clojure.tools.analyzer.passes.trim",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.utils-api.html",
   :name "clojure.tools.analyzer.utils",
   :doc nil}),
 :vars
 ({:name "*env*",
   :namespace "clojure.tools.analyzer.env",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/16abd6b3f3a85196c2addac42de4ff83519cf10f/src/main/clojure/clojure/tools/analyzer/env.clj#L12",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/16abd6b3f3a85196c2addac42de4ff83519cf10f/src/main/clojure/clojure/tools/analyzer/env.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.env/*env*",
   :doc
   "Global env atom\nRequired options:\n * :namespaces an atom containing a map from namespace symbol to namespace map,\n   the namespace map contains at least the following keys:\n  ** :mappings a map of mappings of the namespace, symbol to var/class\n  ** :aliases a map of the aliases of the namespace, symbol to symbol\n  ** :ns a symbol representing the namespace",
   :var-type "var",
   :line 12,
   :file "src/main/clojure/clojure/tools/analyzer/env.clj"}
  {:arglists ([]),
   :name "deref-env",
   :namespace "clojure.tools.analyzer.env",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/16abd6b3f3a85196c2addac42de4ff83519cf10f/src/main/clojure/clojure/tools/analyzer/env.clj#L44",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/16abd6b3f3a85196c2addac42de4ff83519cf10f/src/main/clojure/clojure/tools/analyzer/env.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.env/deref-env",
   :doc
   "Returns the value of the current global env if bound, otherwise\nthrows an exception.",
   :var-type "function",
   :line 44,
   :file "src/main/clojure/clojure/tools/analyzer/env.clj"}
  {:arglists ([env & body]),
   :name "ensure",
   :namespace "clojure.tools.analyzer.env",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/16abd6b3f3a85196c2addac42de4ff83519cf10f/src/main/clojure/clojure/tools/analyzer/env.clj#L36",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/16abd6b3f3a85196c2addac42de4ff83519cf10f/src/main/clojure/clojure/tools/analyzer/env.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.env/ensure",
   :doc
   "If *env* is not bound it binds it to env before executing the body",
   :var-type "macro",
   :line 36,
   :file "src/main/clojure/clojure/tools/analyzer/env.clj"}
  {:arglists ([env & body]),
   :name "with-env",
   :namespace "clojure.tools.analyzer.env",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/16abd6b3f3a85196c2addac42de4ff83519cf10f/src/main/clojure/clojure/tools/analyzer/env.clj#L22",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/16abd6b3f3a85196c2addac42de4ff83519cf10f/src/main/clojure/clojure/tools/analyzer/env.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.env/with-env",
   :doc "Binds the global env to env, then executes the body",
   :var-type "macro",
   :line 22,
   :file "src/main/clojure/clojure/tools/analyzer/env.clj"}
  {:arglists ([ast]),
   :name "elide-meta",
   :namespace "clojure.tools.analyzer.passes.elide-meta",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/b4957158301682c10537738869a90f830705908f/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj#L79",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/b4957158301682c10537738869a90f830705908f/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.elide-meta/elide-meta",
   :doc
   "If elides is not empty and the AST node contains metadata,\ndissoc all the keys in elides from the metadata.",
   :var-type "function",
   :line 79,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj"}
  {:name "elides",
   :namespace "clojure.tools.analyzer.passes.elide-meta",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/b4957158301682c10537738869a90f830705908f/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj#L11",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/b4957158301682c10537738869a90f830705908f/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.elide-meta/elides",
   :doc
   "A map of op keywords to predicate IFns.\nThe predicate will be used to indicate what map keys should be elided on\nmetadata of nodes for that op.\n:all can be used to indicate what should be elided for every node with\nmetadata.\nDefaults to {:all (set (:elide-meta *compiler-options*))}",
   :var-type "var",
   :line 11,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj"}
  {:arglists ([{:keys [form], :as ast} opts]),
   :name "-emit-form*",
   :namespace "clojure.tools.analyzer.passes.emit-form",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/aaf32c60b016770c5cdb76e44721a8897caf75da/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj#L13",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/aaf32c60b016770c5cdb76e44721a8897caf75da/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.emit-form/-emit-form*",
   :doc
   "Extension point for custom emit-form implementations, should be rebound\nto a multimethod with custom emit-form :opts.",
   :var-type "function",
   :line 13,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj"}
  {:arglists ([ast] [ast opts]),
   :name "emit-form",
   :namespace "clojure.tools.analyzer.passes.emit-form",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/aaf32c60b016770c5cdb76e44721a8897caf75da/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj#L23",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/aaf32c60b016770c5cdb76e44721a8897caf75da/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.emit-form/emit-form",
   :doc
   "Return the form represented by the given AST.\nOpts is a set of options, valid options are:\n * :hygienic",
   :var-type "function",
   :line 23,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj"}
  {:arglists ([ast]),
   :name "emit-hygienic-form",
   :namespace "clojure.tools.analyzer.passes.emit-form",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/aaf32c60b016770c5cdb76e44721a8897caf75da/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj#L30",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/aaf32c60b016770c5cdb76e44721a8897caf75da/src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.emit-form/emit-hygienic-form",
   :doc "Return an hygienic form represented by the given AST",
   :var-type "function",
   :line 30,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/emit_form.clj"}
  {:arglists ([ast]),
   :name "index-vector-nodes",
   :namespace "clojure.tools.analyzer.passes.index-vector-nodes",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/fba761428d27ce927c5d5237778dfd0162376c62/src/main/clojure/clojure/tools/analyzer/passes/index_vector_nodes.clj#L11",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/fba761428d27ce927c5d5237778dfd0162376c62/src/main/clojure/clojure/tools/analyzer/passes/index_vector_nodes.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.index-vector-nodes/index-vector-nodes",
   :doc
   "Adds an :idx attribute to nodes in a vector children, representing the position\nof the node vector.",
   :var-type "function",
   :line 11,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/index_vector_nodes.clj"}
  {:file "src/main/clojure/clojure/tools/analyzer/passes/trim.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/fba761428d27ce927c5d5237778dfd0162376c62/src/main/clojure/clojure/tools/analyzer/passes/trim.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/fba761428d27ce927c5d5237778dfd0162376c62/src/main/clojure/clojure/tools/analyzer/passes/trim.clj#L12",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.trim/trim",
   :namespace "clojure.tools.analyzer.passes.trim",
   :line 12,
   :var-type "multimethod",
   :doc
   "Trims the AST from duplicate :do nodes or useless :let nodes.\nWARNING: Still experimental, possibly useful metadata-stored info\n         might get lost",
   :name "trim"}
  {:arglists ([fn argc]),
   :name "arglist-for-arity",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L158",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/arglist-for-arity",
   :doc "Takes a fn node and an argc and returns the matching arglist",
   :var-type "function",
   :line 158,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([x]),
   :name "boolean?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L85",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/boolean?",
   :doc "Returns true if x is a boolean",
   :var-type "function",
   :line 85,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([form]),
   :name "classify",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L90",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/classify",
   :doc "Returns a keyword describing the form type",
   :var-type "function",
   :line 90,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([var]),
   :name "constant?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L122",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/constant?",
   :doc "Returns true if the var is a const",
   :var-type "function",
   :line 122,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([env ctx]),
   :name "ctx",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L25",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/ctx",
   :doc
   "Returns a copy of the passed environment with :context set to ctx",
   :var-type "function",
   :line 25,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([ast]),
   :name "dissoc-env",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L30",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/dissoc-env",
   :doc "Dissocs :env from the ast",
   :var-type "function",
   :line 30,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([var]),
   :name "dynamic?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L127",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/dynamic?",
   :doc "Returns true if the var is dynamic",
   :var-type "function",
   :line 127,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([to from]),
   :name "into!",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L15",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/into!",
   :doc "Like into, but for transients",
   :var-type "function",
   :line 15,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([var]),
   :name "macro?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L117",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/macro?",
   :doc "Returns true if the var maps to a macro",
   :var-type "function",
   :line 117,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([x]),
   :name "obj?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L60",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/obj?",
   :doc "Returns true if x implements IObj",
   :var-type "function",
   :line 60,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([var]),
   :name "private?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L112",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/private?",
   :doc "Returns true if the var is private",
   :var-type "function",
   :line 112,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([var]),
   :name "protocol-node?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L134",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/protocol-node?",
   :doc "Returns true if the var maps to a protocol function",
   :var-type "function",
   :line 134,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([x]),
   :name "record?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L50",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/record?",
   :doc "Returns true if x is a record",
   :var-type "function",
   :line 50,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([x]),
   :name "reference?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L65",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/reference?",
   :doc "Returns true if x implements IReference",
   :var-type "function",
   :line 65,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([x]),
   :name "regex?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L77",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/regex?",
   :doc "Returns true if x is a regex",
   :var-type "function",
   :line 77,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([ns-sym {:keys [ns]}]),
   :name "resolve-ns",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L139",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/resolve-ns",
   :doc "Resolves the ns mapped by the given sym in the env",
   :var-type "function",
   :line 139,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([sym {:keys [ns], :as env}]),
   :name "resolve-var",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L147",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/resolve-var",
   :doc "Resolves the var mapped by the given sym in the env",
   :var-type "function",
   :line 147,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([v]),
   :name "rseqv",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L20",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/rseqv",
   :doc "Same as (comp vec rseq)",
   :var-type "function",
   :line 20,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([x]),
   :name "type?",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L55",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/type?",
   :doc "Returns true if x is a type",
   :var-type "function",
   :line 55,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([m f]),
   :name "update-keys",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L40",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/update-keys",
   :doc "Applies f to all the keys in the map",
   :var-type "function",
   :line 40,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([m f]),
   :name "update-kv",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L45",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/update-kv",
   :doc "Applies f to all the keys and vals in the map",
   :var-type "function",
   :line 45,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([m f]),
   :name "update-vals",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj#L35",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/d892d18328693e7330abe7e99526ca6b7aeee919/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/update-vals",
   :doc "Applies f to all the vals in the map",
   :var-type "function",
   :line 35,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"})}
