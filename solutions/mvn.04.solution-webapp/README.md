# Usage:
```
mvn jetty:run
```
Following pages are available:
- <http://localhost:8080> the index page served from [index.jsp](src/main/webapp/index.jsp)
- <http://localhost:8080/simple> served from the [SimpleServlet](src/main/java/course/maven/SimpleServlet.java) servlet

Additionally the project is configured to:
- start the webserver on a free port in the `pre-integration-test`phase
- execute integration tests
- stop the webserver `post-integration-test` phase