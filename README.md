## Keycloak

### Introduction
- Open Source Software for Identity and Access Management
Under RedHat
- First release in 2014

### Setup and Running
- Download Keycloak from https://www.keycloak.org/getting-started/getting-started-zip
- Run *standalone.bat* on windows or *standalone.sh* on linux


### Database
- By Default, Keycloak uses H2 database
- Can be configured to use any external relation database
- No support for NoSql out of the box
- Mongo was once supported but support was withdrawn since 2017
- https://lists.jboss.org/pipermail/keycloak-user/2017-February/009417.html
- https://lists.jboss.org/pipermail/keycloak-user/2018-May/013958.html


### Setting up external database
- https://wjw465150.gitbooks.io/keycloak-documentation/content/server_installation/topics/database.html


### Database Schema
- [Keycloak Database Schema](https://raw.githubusercontent.com/gist/thomasdarimont/b1c19da5e8df747b8596e6ddcda7e36f/raw/29309467f4ea07519cf614fd74943272e7d939f4/keycloak_db_overview_4.0.0.CR1-SNAPSHOT.svg)


### Keycloak Spring Boot Adapter
- https://www.tutorialsbuddy.com/keycloak-secure-spring-boot-rest-api


### Keycloak Rest Api  :
- Postman Collection :
    https://documenter.getpostman.com/view/7294517/SzmfZHnd#f0ede40d-d0d5-4315-86dc-1be652017dd9


- Rest Api Doc :  
    https://www.keycloak.org/docs-api/15.0/rest-api/

