# tools.analyzer

An analyzer for host agnostic Clojure code, written in Clojure and producing AST in EDN.

Timothy Baldridge gave a talk on tools.analyzer[.jvm] at Clojure/West in
March 2014. Video
[here](https://www.youtube.com/watch?v=KhRQmT22SSg&list=PLZdCLR02grLp__wRg5OTavVj4wefg69hM&index=11).

Note that the analyzer in this library should not to be used directly as it lacks any knowledge about host-specific special forms and it should only be considered as a building platform for host-specific analyzers.
Currently the following platform specific analyzers written on top of tools.analyzer exist: [tools.analyzer.jvm](https://github.com/clojure/tools.analyzer.jvm), [tools.analyzer.js](https://github.com/clojure/tools.analyzer.js)

* [Example Usage](#example-usage)
* [Quickref](#quickref)
* [Releases and Dependency Information](#releases-and-dependency-information)
* [Changelog](#changelog)
* [API Index](#api-index)
* [Developer Information](#developer-information)
* [License](#license)

[Quickref](http://clojure.github.io/tools.analyzer/spec/quickref.html)
========================================

## Example Usage
`clojure.tools.analyzer/analyze` will not work out of the box, as it requires a number of entry-points to be set.
Here's what could happen trying to use `clojure.tools.analyzer/analyze` directly:
```clojure
clojure.tools.analyzer> (analyze 'a {})
Attempting to call unbound fn: #'clojure.tools.analyzer/macroexpand-1
  [Thrown class java.lang.IllegalStateException]
```

At the moment there exist two official analyzers written on top of [tools.analyzer](https://github.com/clojure/tools.analyzer): [tools.analyzer.jvm](https://github.com/clojure/tools.analyzer.jvm) for clojure on the JVM and [tools.analyzer.js](https://github.com/clojure/tools.analyzer.js) for clojurescript.
We will use [tools.analyzer.jvm](https://github.com/clojure/tools.analyzer.jvm) for those examples.

Here's a simplified version of how `clojure.tools.analyzer.jvm/analyze` is defined:
```clojure
(require '[clojure.tools.analyzer :as ana])
(require '[clojure.tools.analyzer.env :as env])
(defn analyze [form env]
  (binding [ana/macroexpand-1 macroexpand-1
            ana/create-var    create-var
            ana/parse         parse
            ana/var?          var?]
       (env/ensure (global-env)
         (run-passes (-analyze form env))))))
```

Here, `-analyze` is a multimethod that defaults to `ana/analyze` and defines analysis methods for the JVM specific special forms, `global-env` is a function that returns a global environment for the JVM analyzer and `run-passes` is a function that takes an AST and applies a number of passes to it.

The `tools.analyzer.jvm` [README](https://github.com/clojure/tools.analyzer.jvm#example-usage) contains more examples on how the `analyze` function works as well as a reference for all the nodes it can return.

One of the most important features of `tools.analyzer` is the ability to walk generically through the AST nodes, this has been immensely useful to write most of the passes used by the various analyzers.
The `tools.analyzer.ast` namespace provides a number of functions that implement various generic AST walking strategies.

The `children` function returns a vector of the children nodes of the current node (the output has been elided and pretty-printed for clarity):
```clojure
clojure.tools.analyzer.jvm> (require '[clojure.tools.analyzer.ast :as ast])
nil
clojure.tools.analyzer.jvm> (ast/children (analyze '(do 1 2 :foo)))
[{:op   :const,
  :id   0,
  :type :number,
  :val  1,
  :form 1,
  ...}
 {:op   :const,
  :id   1,
  :type :number,
  :val  2,
  :form 2,
  ...}
 {:op   :const,
  :id   3,
  :type :keyword,
  :val  :foo,
  :form :foo,
  ...}]
```

If we want to access a flattened view of all the nodes of an AST, we can use the `nodes` function:
```clojure
clojure.tools.analyzer.jvm> (ast/nodes (analyze '[1 (+ 1 2)]))
({:op        :vector,
  :top-level true,
  :items
  [{:op   :const,
    :type :number,
    :val  1,
    ...}
   {:op     :static-call,
    :class  clojure.lang.Numbers,
    :method add,
    :form   (. clojure.lang.Numbers (add 1 2)),
    :args   [{:op  :const,
              :val 1,
              ...}
             {:op  :const,
              :val 2,
              ...}],
   ...}]
  :form [1 (+ 1 2)],
  ...}
 {:op   :const,
  :type :number,
  :val  1,
  ...}
 {:op    :static-call,
  :class  clojure.lang.Numbers,
  :method add,
  :form   (. clojure.lang.Numbers (add 1 2)),
  :args [{:op  :const,
          :val 1,
          ...}
         {:op  :const,
          :val 2,
          ...}],
  ...}
  ..)
```

The `update-children` function takes an AST node and a function and replaces the children nodes of the given node with the result of applying the function to each children node.
```clojure
clojure.tools.analyzer.jvm> (ast/update-children (analyze '(do 1 (+ 1 2) :foo))
                               #(assoc % :visited true))
{:op :do
 :statements
 [{:op      :const,
   :val     1,
   :visited true,
   ...}
  {:op      :static-call,
   :class   clojure.lang.Numbers,
   :method  add,
   :visited true,
   :args   [{:op  :const
             :val 1,
             ...}
            {:op  :const,
             :val 2,
             ...}],
   ...}]
 :ret
 {:op      :const,
  :val     :foo,
  :visited true,
  ...},
 ...}
```
If it's desiderable to walk all the AST applying a function to all the nodes and the children nodes, one of `walk`, `prewalk` or `postwalk` should be used, read the docstrings of the three functions to understand the differences.
Here's the previous example using `prewalk` instead of `update-children`:
```clojure
clojure.tools.analyzer.jvm> (ast/prewalk (analyze '(do 1 (+ 1 2) :foo))
                               #(assoc % :visited true))
{:op      :do
 :visited true,
 :statements
 [{:op      :const,
   :val     1,
   :visited true,
   ...}
  {:op      :static-call,
   :class   clojure.lang.Numbers,
   :method  add,
   :visited true,
   :args   [{:op      :const
             :val     1,
             :visited true,
             ...}
            {:op     :const,
             :val     2,
             :visited true,
             ...}],
   ...}]
 :ret
 {:op      :const,
  :val     :foo,
  :visited true,
  ...},
 ...}
```
As you can see, this time all the nodes have been marked `:visited`.

Since version `0.6.0`, passes can be scheduled automatically using `clojure.tools.analyzer.passes/schedule` rather than having to compose them and sort out pass dependencies manually, refer to its docstrings and examples from `tools.analyzer.jvm` for more info.

## SPONSORSHIP

* Cognitect (http://cognitect.com/) is sponsoring tools.analyzer development (https://groups.google.com/d/msg/clojure/iaP16MHpX0E/EMtnGmOz-rgJ)
* Ambrose BS (https://twitter.com/ambrosebs) has sponsored tools.analyzer development in his typed clojure campaign (http://www.indiegogo.com/projects/typed-clojure).

## YourKit

YourKit has given an open source license for their profiler, greatly simplifying the profiling of tools.analyzer performance.

YourKit is kindly supporting open source projects with its full-featured Java Profiler. YourKit, LLC is the creator of innovative and intelligent tools for profiling Java and .NET applications. Take a look at YourKit's leading software products:

* <a href="http://www.yourkit.com/java/profiler/index.jsp">YourKit Java Profiler</a> and
* <a href="http://www.yourkit.com/.net/profiler/index.jsp">YourKit .NET Profiler</a>.

Releases and Dependency Information
========================================

Latest stable release: 0.6.2

* [All Released Versions](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22org.clojure%22%20AND%20a%3A%22tools.analyzer%22)

* [Development Snapshot Versions](https://oss.sonatype.org/index.html#nexus-search;gav%7Eorg.clojure%7Etools.analyzer%7E%7E%7E)

[Leiningen](https://github.com/technomancy/leiningen) dependency information:

```clojure
[org.clojure/tools.analyzer "0.6.2"]
```
[Maven](http://maven.apache.org/) dependency information:

```xml
<dependency>
  <groupId>org.clojure</groupId>
  <artifactId>tools.analyzer</artifactId>
  <version>0.6.2</version>
</dependency>
```

[Changelog](CHANGELOG.md)
========================================

API Index
========================================

* [CrossClj Documentation](http://crossclj.info/doc/org.clojure/tools.analyzer/lastest/index.html)
* [API index](http://clojure.github.io/tools.analyzer)

Developer Information
========================================

* [GitHub project](https://github.com/clojure/tools.analyzer)

* [Bug Tracker](http://dev.clojure.org/jira/browse/TANAL)

* [Continuous Integration](http://build.clojure.org/job/tools.analyzer/)

* [Compatibility Test Matrix](http://build.clojure.org/job/tools.analyzer-test-matrix/)

## License

Copyright © 2013-2014 Nicola Mometto, Rich Hickey & contributors.

Distributed under the Eclipse Public License, the same as Clojure.
