# Example of failing dependency resolution

Here we have:
- a has dependency to b & c
- b has dependency to d version 1 (hard reference)
- c has dependency to d version 2 (hard reference)

## Install leads to error
```
mvn install

...

[INFO] Reactor Summary:
[INFO] 
[INFO] d 2 ................................................ SUCCESS [  0.774 s]
[INFO] d 1 ................................................ SUCCESS [  0.032 s]
[INFO] b 0.1-SNAPSHOT ..................................... SUCCESS [  0.042 s]
[INFO] c 0.1-SNAPSHOT ..................................... SUCCESS [  0.029 s]
[INFO] a 0.1-SNAPSHOT ..................................... FAILURE [  0.005 s]
[INFO] parent 0.1-SNAPSHOT ................................ SKIPPED
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.983 s
[INFO] Finished at: 2020-03-10T18:19:45+01:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal on project a: Could not resolve dependencies for project maven.course.incompatible:a:jar:0.1-SNAPSHOT: Failed to collect dependencies for maven.course.incompatible:a:jar:0.1-SNAPSHOT: Could not resolve version conflict among [maven.course.incompatible:b:jar:0.1-SNAPSHOT -> maven.course.incompatible:d:jar:[1,1], maven.course.incompatible:c:jar:0.1-SNAPSHOT -> maven.course.incompatible:d:jar:[2,2]] -> [Help 1]
...
```