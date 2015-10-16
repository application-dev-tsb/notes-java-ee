# Garbage Collection

## Automatic Garbage Collection
* Marking
* Deletion
* Compacting (Optional)

## Generational Garbage Collection

**JVM Partitions the Heap:**
* Eden - new object are allocated here, minor GCs (stop-the-world event) cleans this up very frequently
* Survivor Space (S0/S1) - survived 1 minor GC, objects are swapped around between S1 and S2
* Tenured (Old Generation) -  survived X (threshold) minor GC are promoted here, still gets cleaned up when a major GC cleans up and compacts the space here
* Metaspace (Permanent Generation) - classes and methods, application metadata


**Sources:**
* [Oracle: GC1](http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html)
