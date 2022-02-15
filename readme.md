# fmchan Latest Spring Cloud Microservices Demo with Java 17

## Architecture

Our sample microservices-based system consists of the following modules:

- **reactive-service** - a module containing Lok's reactive web server with some modifications to match with microservices.
- **gateway-service** - a module for running Spring Boot application that acts as a gateway.
- **config-service** - a module that uses Spring Cloud Config Server for running configuration server in the `native`
  mode. The configuration files are placed on the classpath.
- **discovery-service** - a module that depending on the example it uses Spring Cloud Netflix Eureka or Spring Cloud
  Netlix Alibaba Nacos as an embedded discovery server.
- **employee-service** - a module containing the first of our sample microservices that allows to perform CRUD operation
  on in-memory repository of employees
- **department-service** - a module containing the second of our sample microservices that allows to perform CRUD
  operation on in-memory repository of departments. It communicates with employee-service.
- **organization-service** - a module containing the third of our sample microservices that allows to perform CRUD
  operation on in-memory repository of organizations. It communicates with both employee-service and
  organization-service.

The following picture illustrates the architecture described above.

<img src="https://piotrminkowski.files.wordpress.com/2018/04/spring-cloud-1.png" title="Architecture"><br/>

## Steps for a new service creation

1. Understand the module of employee service or department service
2. create a similar project with the same structure
3. add @SpringBootApplication and @OpenAPIDefinition for main class
4. minor change of application.yml, bulid.gradle, Dockerfile
5. add project name to settings.gradle
6. add yml to config-service like others and add routing path to gateway-service.yml