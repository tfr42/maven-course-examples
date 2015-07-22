### How to convert a Maven build into a Gradle build
Install [gradle](https://gradle.org) and then run from the command line:

```
gradle init --type pom
```

This will create a ```build.gradle``` file (plus others).
To build the project with gradle you can run one of the following tasks:

```
gradle test
gradle build
gradle install
```

To get an overview of all supported gradle tasks run:

```
gradle tasks
```
