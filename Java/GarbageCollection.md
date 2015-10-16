# Garbage Collection

## Automatic Garbage Collection
* Marking
* Deletion
* Compacting (Optional)

## Generation Garbage Collection

**JVM Partitions the Heap:**
* Eden - new object
* Survivor Space (S0/S1) - survived 1 minor GC, objects are swapped around between S1 and S2
* Tenured (Old Generation) -  survived X (threshold) minor GC
* Permanent - classes and methods


**Sources:**
* [Oracle: GC1](http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html)
