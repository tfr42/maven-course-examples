# Example for usage of profiles

- Profile `development` is activated by default.
  Artefact generated by `mvn package` will be named `maven-profiles-development.jar`

- Profile `dmz1` is activated when the environment property `DMZ` is set

```
export DMZ1=1
mvn package
```

causes the generated artefact to be named `maven-profiles-DMZ1.jar`

- Profile `windows` is automatically activated on a windows OS and binds maven-failsafe-plugin's integration-test and verify goals what executes the test [WindowsIT](src/test/java/course/maven/profile/WindowsIT.java)