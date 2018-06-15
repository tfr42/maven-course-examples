# Maven Plugins for Docker

This projects contains a sample ```Dockerfile``` to build a Docker image containing a sample Java application.
The Docker image is build by a Maven plugin.

The following Maven plugins for Docker are available (stable and actively maintained):
 * https://github.com/fabric8io/docker-maven-plugin
 * https://github.com/spotify/docker-maven-plugin
 * https://github.com/wouterd/docker-maven-plugin 
 
This project uses the ```net.wouterdanes.docker:docker-maven-plugin:5.0.0```. Run the following goal to build the image:

    % mvn package
    
Use the property ```java.major.version``` to specify the Java SE version which is used to run the application. 
To build the Docker image with Java 1.9 run:
    
    % mvn clean package -Djava.major.version=9
    
Which is similar to:

    % cd target/classes 
    % docker build -t tfr42/docker-example:1.0.0-SNAPSHOT --build-arg jarfile=docker-example.jar .

On macOS with Docker for Mac the Maven plugin requires the Docker Daemons REST API. As a workaround you can run:
    
    % docker run -d -v /var/run/docker.sock:/var/run/docker.sock -p 127.0.0.1:1234:1234 bobrik/socat TCP-LISTEN:1234,fork UNIX-CONNECT:/var/run/docker.sock
    % export DOCKER_HOST=tcp://localhost:1234

To run the Docker container execute:
    
    % docker run --rm tfr42/docker-example:1.0.0-SNAPSHOT 

Check the [Docker web site](https://www.docker.com/) for more information about Docker! 

Very helpful information about Docker and Maven Plugins for Docker can be found here:
 * https://github.com/fabric8io/shootout-docker-maven
 * https://jaxenter.de/docker-mit-maven-steuern-20211 (German)
 * https://github.com/rossbachp/dockerbox (Setup docker environment with Vagrant, German)
 * http://ro14nd.de/talks/2014/wjax-docker-fuer-entwickler.pdf (slides in German)
 * http://www.slideshare.net/robertreiz/docker-39958028 (slides in in English)
