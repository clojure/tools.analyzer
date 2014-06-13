# tools.analyzer

An analyzer for Clojure code, written in Clojure and producing AST in EDN.

Timothy Baldridge gave a talk on tools.analyzer[.jvm] at Clojure/West in
March 2014. Video
[here](https://www.youtube.com/watch?v=KhRQmT22SSg&list=PLZdCLR02grLp__wRg5OTavVj4wefg69hM&index=11).

Note that this library is not to be used directly, instead platform specific extensions should be used.
Currently the following platform specific extensions exist: [tools.analyzer.jvm](https://github.com/clojure/tools.analyzer.jvm), [tools.analyzer.js](https://github.com/clojure/tools.analyzer.js)

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

Latest stable release: 0.2.2

* [All Released Versions](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22org.clojure%22%20AND%20a%3A%22tools.analyzer%22)

* [Development Snapshot Versions](https://oss.sonatype.org/index.html#nexus-search;gav%7Eorg.clojure%7Etools.analyzer%7E%7E%7E)

[Leiningen](https://github.com/technomancy/leiningen) dependency information:

```clojure
[org.clojure/tools.analyzer "0.2.2"]
```
[Maven](http://maven.apache.org/) dependency information:

```xml
<dependency>
  <groupId>org.clojure</groupId>
  <artifactId>tools.analyzer</artifactId>
  <version>0.2.2</version>
</dependency>
```

[Changelog](CHANGELOG.md)
========================================

Developer Information
========================================

* [GitHub project](https://github.com/clojure/tools.analyzer)

* [Bug Tracker](http://dev.clojure.org/jira/browse/TANAL)

* [Continuous Integration](http://build.clojure.org/job/tools.analyzer/)

* [Compatibility Test Matrix](http://build.clojure.org/job/tools.analyzer-test-matrix/)

## License

Copyright © 2013-2014 Nicola Mometto, Rich Hickey & contributors.

Distributed under the Eclipse Public License, the same as Clojure.
