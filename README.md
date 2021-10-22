# Ticketing System for Public Transport Network
This the back end service pf the Ticket System, developed in Springboot. The following APIs are inclided in this backend services
1. Passenger APIs
2. Bus/Driver APIs

## General steps
1. Update mysql host and credentials in application-local.properties
2. Update mysql configs in pom.xml under flyway plugin
3. Run flyawy migration to create tables `mvn flyway:migrate`

## Run Unit Tests
`mvn test`

## Run JAR File
1. Package `mvn clean package`
2. Run `java - jar target/ticketingSystem-0.0.1-SNAPSHOT.jar`

## Run with docker compose
This application has been dockerized. Follow the below-mentioned steps run it on docker.
1. Configurations
   * change mysql host in the application property file
2. Build `` docker-compose up --build``
3. Run ``docker-compose up``