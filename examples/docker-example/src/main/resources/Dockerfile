FROM ${docker.baseImage}
ARG jarfile
ADD ${jarfile} /helloworld.jar
CMD ["java", "-jar", "/helloworld.jar"]