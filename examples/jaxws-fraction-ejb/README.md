# Run Glassfish Server on Docker
 
    docker pull airhacks/glassfish
    docker run --rm --name glassfish5 -p 8080:8080 -p 8181:8181 -p 8009:8009 -p 4848:4848 -v $(pwd)/target/fraction.jar:/glassfish5/glassfish/domains/domain1/autodeploy/fraction.jar airhacks/glassfish

## Admin Console
http://localhost:4848/
Username: admin
Password: 

## Dockerfile for Glassfish v5
https://github.com/AdamBien/docklands/blob/master/glassfish5/Dockerfile