# Usage

This folder contains 2 separated maven projects that can be built as:
```
cd simple-weather
mvn install
cd ../simple-webapp
mvn install
```

The webapp can be started in the `simple-webapp` dir with:
```
mvn jetty:run
```

# Exercise goal
- optimize to build with a single maven call
- reduce duplications

