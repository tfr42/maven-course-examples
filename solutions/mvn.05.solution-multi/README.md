# Usage:
```
mvn install
```
This:
- builds the subprojects
- execute the tests (including integration tests)
- deploys artefacts to the local directory

Web-server can be started in `simple-webapp` folder:
```
mvn jetty:run
```

The weather form is then available at <http://localhost:8088/>.
