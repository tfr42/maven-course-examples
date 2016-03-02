# Maven Docker Plugins

This projects contains a sample ```Dockerfile``` for building a Docker image containing a sample Java application.
The Docker image is build by a Maven plugin.

The following Maven plugins are available:
 * https://github.com/wouterd/docker-maven-plugin 
 * https://github.com/spotify/docker-maven-plugin
 * https://github.com/fabric8io/docker-maven-plugin
 * https://github.com/alexec/docker-maven-plugin 

This project uses the ```net.wouterdanes.docker:docker-maven-plugin:5.0.0```. Run the following goal to build the image:

    % mvn package
    
To run the Docker container use:
    
    % docker run --rm tfr42/docker-example:1.0.0-SNAPSHOT 

The [Docker web site](https://www.docker.com/) provides all information 
about Docker! Very helpful information about Docker and Maven Plugins can be found here:
 * https://github.com/fabric8io/shootout-docker-maven
 * https://jaxenter.de/docker-mit-maven-steuern-20211 (German)
 * http://ro14nd.de/talks/2014/wjax-docker-fuer-entwickler.pdf (slides in German)
