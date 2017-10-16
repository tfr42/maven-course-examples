# Run JBoss AS 7 on Docker
    docker pull pascalgrimaud/jboss-as
    docker run --rm --name jbossas7 -p 8080:8080 -p 9990:9990 -e JBOSS_PASS="pass" -v ~/git/maven-course-examples/examples/jaxws-fraction-service/target/jaxws-fraction-service-1.0.0-SNAPSHOT.war:/opt/jboss-as-7.1.1.Final/standalone/deployments/jaxws-fraction-service.war pascalgrimaud/jboss-as
    
## Admin Console

http://localhost:9990/
Username: admin
Password: pass

## Dockerfile
https://github.com/pascalgrimaud/docker-jboss-as/    