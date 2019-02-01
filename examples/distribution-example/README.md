# Setup

To use this example to exercise release deployment, following needs to be setup previously:
- a Nexus server
- a Git server with this example project in a repository (reachable with the credentials maven-course/secret) 


# Deploying to Nexus Repository Manager 

To deploy the build artifact a running instance of Nexus Repository OSS or Pro is required.

To use the provided Maven `settings.xml` with the Nexus default accounts run Maven with:
			
    mvn -s src/main/resources/config/settings.xml deploy
 
## Using docker to run Nexus Repository Manager

Using the official image from https://hub.docker.com/r/sonatype/nexus3/:

    $ docker pull sonatype/nexus3

### Start docker container with Nexus Repository Manager

To run, binding the exposed port 8081 to the host.
     
     $ docker run -d -p 8081:8081 --name nexus sonatype/nexus3   

### Access Nexus Repository Manager

http://localhost:8081/nexus

Default admin user login (admin/admin123)    