Changelog
========================================
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
