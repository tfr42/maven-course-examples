# Build the multi module project

    mvn clean install

## Run the project on JBoss AS

To deploy and run the application on Wildfly (15) run in the `application` directory:

    cd application
    mvn wildfly:run

Open <http://localhost:8080/webclient/>
