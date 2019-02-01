
# Install the archetype
```
mvn install
```


# Use it to generate a new project

```
cd /tmp
mvn archetype:generate \
      -DarchetypeGroupId=maven.course \
      -DarchetypeArtifactId=project-pattern-archetype \
      -DarchetypeVersion=1.0.0-SNAPSHOT \
      -DgroupId=my.newest.project \
      -DartifactId=my-newest-artifact

```
      