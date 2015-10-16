# Just-In-Time Compiler
* JVMs run code in both interpreted and compiled mode

## Optimizations
* Hot Spot Detection - immediately executes code in the interpreter, and only performs optimizations in frequently-invoked codes
* Method Inlining - reduces the dynamic frequency of method invocations
* Dynamic Deoptimization - reverts optimizations when needed
* Dead Code Ellimination
* Loop Unraveling
* Lock Ellimination
* Remove Prechecking for NullPointers and IndexOutOfBoundsException


**Sources:**
* [Oracle: Compiler Optimization](http://www.oracle.com/technetwork/java/whitepaper-135217.html#optimizations)
* [Oracle: JRockit JVM](http://docs.oracle.com/cd/E15289_01/doc.40/e15058/underst_jit.htm)
* [Some Blog](http://artiomg.blogspot.com/2011/10/just-in-time-compiler-jit-in-hotspot.html)
