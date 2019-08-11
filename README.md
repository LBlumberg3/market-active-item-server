# Market Active Item Server
Simple Spring Boot API providing CRUD functionality for items listed in an online marketplace. 

The basic premise is a craigslist / facebook marketplace clone. This repository is for a service that only deals with
 items currently available to see through the public interface. Historical data will be handled by a separate
  service, to keep everything narrowly focused. 

Database integration is done by having the Spring Context inject an adapter to an in-memory H2 database. I chose this
 method because: 

A) It is one fewer external dependency for an example project - this project will become ready for a demo later 

B) I won't have to worry about unintentionally having DB credentials in a public repository 

C) It's easier 

## Technology Stack
This repository uses Java 8 and Spring Boot, with slf4j/logback for logging, Hibernate/Spring Data JPA for ORM
 features, H2 for the SQL Datasource, a Tomcat Server for HTTP traffic, and (later) Docker as a Container Runtime.  