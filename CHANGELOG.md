Changelog
========================================

* Release 1.2.1 on 30 Dec 2025
  * Update parent pom
* Release 1.2.0 on 19 Feb 2024
  * Update parent pom
* Release 1.1.1 on 26 Nov 2022
  * Remove JVM-specific code to make this usable for ClojureCLR
* Release 1.1.0 on 14 Sep 2021
  * TANAL-134: Remove :init from :def's :children when absent
  * Added :refer-clojure :exclude for `update-keys` and `update-vals` being added in Clojure 1.11
* Release 1.0.0 on 18 Feb 2020
  * Fixed docstrings
* Release 0.7.0 on 10 Dec 2018
  * Handle injected locals in add-binding-atom phase
* Release 0.6.9 on 9 Jun 2015
  * Exclude `boolean?` from clojure.core
* Release 0.6.7 on 3 Nov 2015
  * Don't elide significant 'quote
* Release 0.6.6 on 23 Apr 2015
  * Fix emit-form for :host-field
* Release 0.6.5 on 23 Feb 2015
  * Small performance enhancements
  * Fixed some metadata handling
  * Removed :ctx.invoke, derive :ctx/return from :ctx/expr
  * Renamed resolve-var to resolve-sym
  * Attached resolved op to :raw-forms
  * Added var special form
* Release 0.6.4 on 20 Nov 2014
  * Fixed a bug in the pass scheduler regarding transitive deps
  * Added reduced support for update-children, walk, prewalk and postwalk
  * Fixed parsing of catch expressions outside a try block
* Release 0.6.3 on 03 Oct 2014
  * Preserve correct meta on emit-form
  * Preserve :raw-forms in elide-meta
  * Better source-info propagation
* Release 0.6.2 on 27 Oct 2014
  * Fixes and improvements for looping pass scheduling
  * Performance improvements on the scheduled pass function
* Release 0.6.1 on 13 Oct 2014
  * Significant performance enhancements
  * Fixed scheduling of looping passes
  * Uniquify :env :locals only if the :uniquify/uniquify-env pass-opt is true
* Release 0.6.0 on 18 Sep 2014
  * Added pass scheduler (clojure.tools.analyzer.passes/schedule) and configured all the passes
  * Changed the interface of the collect-closed-overs pass
  * Changed the interface of the add-binding-atom pass
  * Removed the (experimental) trim pass
* Release 0.5.3 on 31 Aug 2014
  * Made the source clojure-clr compatible
  * Added butlast+last to utils
* Release 0.5.2 on 20 Aug 2014
  * Compare contexts with isa? rather than =
* Release 0.5.1 on 09 Aug 2014
  * Removed collect pass
  * Moved collect-closed-overs pass to its own namespace
* Release 0.5.0 on 29 Jul 2014
  * Made :host-field and :host-interop :assignable?
* Release 0.4.0 on 26 Jul 2014
  * BREAKING CHANGE: The :class field for :new and :catch nodes are now children nodes rather than symbols
  * More fine-grained elide-meta
* Release 0.3.0 on 21 Jun 2014
  * BREAKING API CHANGE: :context is now either :ctx/statement, :ctx/return, :ctx/expr or a keyword derived from one of those
  * elide-meta: elides can be any IFn, not only a set
  * analyze :symbol will not throw when a Var is not found
* Release 0.2.3 on 16 Jun 2014
  * Preserve :raw-forms for macroexpanded symbols
  * Add :end-line :end-column info to source-info (only when directly available)
* Release 0.2.2 on 13 Jun 2014
  * :fn node can be wrapped by :with-meta
  * Remove :meta from :def :children when elide-meta removes it
* Release 0.2.1 on 08 Jun 2014
  * Made constant-lift preserve the original AST fields
  * Made elide-meta discard all meta on form if metadata becomes nil
* Release 0.2.0 on 05 Jun 2014
  * BREAKING API CHANGE: Add global-env interface, move :namespaces from env to the global env
  * Preserve original forms under :raw-forms in case of macroexpansion
  * Open analyze-form dispatch
  * Fixed collect-closed-overs for letfn*
  * Make cleanup work on :env :locals
* Release 0.1.0-beta13 on 11 Mar 2014
  * Fix elide-meta pass
* Release 0.1.0-beta12 on 25 Apr 2014
  * Annotated top-level nodes with :top-level true
  * Moved rseqv and into! to the c.t.a.utils namespace
  * Don't uniquify "constructed" locals
  * Preserve :locals in :env, uniquify locals :name in :env :locals
* Release 0.1.0-beta11 on 18 Apr 2014
  * Reduced the number of calls to `symbol`, leading to some performance improvements
  * Performance improvements on the uniquify pass
  * BREAKING API CHANGE: ast/children* now returns a vector of [key node] rather than
    a vector of nodes
  * Performance improvement on ast/update-children
  * Added options set to emit-form
* Release 0.1.0-beta10 on 1 Apr 2014
  * Don't discard macroexpanded form meta, merge it with &form meta
  * Improvements on source-info handling
* Release 0.1.0-beta9 on 29 Mar 2014
  * Fixed a bug in constant-lift regarding array-maps
  * Fixed elide-meta implementation
  * :const nodes will have :meta only if the const object is an IObj
* Release 0.1.0-beta8 on 11 Mar 2014
  * Removed :name in env for the :fn name, moved in a tools.analyzer.jvm pass
  * Added docstrings
* Release 0.1.0-beta7 on 28 Feb 2014
  * Fix macroexpand implementation
* Release 0.1.0-beta5 on 26 Feb 2014
  * Unwrap the try if there's no catch/finally
  * Fixed uniquify pass on letfn bindings
  * Correctly quote :arglists meta in def sym
* Release 0.1.0-beta4 on 17 Feb 2014
  * Analyze throws on `(quote)`
  * General code cleanup, added docstrings
  * Changed :loop-locals to hold the count of locals rather than their form
    Holding their form was problematic since the uniquify pass would invaldiate those
  * Attached :once to :fn nodes when ^:once fn*
* Release 0.1.0-beta3 on 15 Feb 2014
  * Allowed :top-level collecting for collect-closed-overs
* Release 0.1.0-beta2 on 14 Feb 2014
  * Fixed fn name munging
* Release 0.1.0-beta1 on 11 Feb 2014
  * First beta release
