# Garbage Collection

## Garbage Collection Steps
* Marking
* Deletion
* Compacting (Optional)

## Generational Garbage Collection

**JVM Partitions the Heap:**
* Eden - new object are allocated here, minor GCs (stop-the-world event) cleans this up very frequently
* Survivor Space (S0/S1) - survived 1 minor GC, objects are swapped around between S1 and S2
* Tenured (Old Generation) -  survived X (threshold) minor GC are promoted here, still gets cleaned up when a major GC cleans up and compacts the space here
* Metaspace (Permanent Generation) - classes and methods, application metadata

**For Visualization:**
* run **jvisualvm**
* install the Visual GC plugin

![Visual VM](/Images/VisualVM.png)

## Command Line Switches
```
java -Xmx12m -Xms3m -Xmn1m -XX:PermSize=20m -XX:MaxPermSize=20m -XX:+UseSerialGC -jar Java2demo.jar
```
Switch            | Description
----------------- | ------------
-Xms              | Sets the initial heap size for when the JVM starts
-Xmx              | Sets the maximum heap size
-Xmn              | Sets the size of the Young Generation
-XX:PermSize      | Sets the starting size of the Permanent Generation
-XX:MaxPermSize   | Sets the maximum size of the Permanent Generation
-XX:+UseSerialGC  | Enable Serial Collector
-XX:+UseParallelGC| Enable Parallel Collector, use -XX:ParallelGCThreads=<desired number> to specify thread count

**-XX:+UseParallelGC**
* multi-threaded young generation collector
* single-threaded old generation collector
* single-threaded compaction

**-XX:+UseParallelOldGC**
* everything is multithreaded

**Sources:**
* [Oracle: GC1](http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html)
