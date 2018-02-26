# Reports

## SonarQube

More information at http://www.mojohaus.org/sonar-maven-plugin/plugin-info.html

### Docker Image

https://hub.docker.com/_/sonarqube/

### Analyzing mit Maven SonarQube Plugin
    
    mvn clean verify sonar:sonar
    
https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner+for+Maven

Example project: https://github.com/SonarSource/sonar-scanning-examples/tree/master/sonarqube-scanner-maven

## Licence Check

Add licence header to source files with:

    mvn  -Dlicense.addJavaLicenseAfterPackage=false -Dlicense.licenseName=lgpl_v2_1 license:update-file-header
    
Download all licence files with:
         
    mvn license:download-licenses
    
Generate THIRD-PARTY.txt file with:

    mvn license:add-third-party
    
More information at http://www.mojohaus.org/license-maven-plugin/