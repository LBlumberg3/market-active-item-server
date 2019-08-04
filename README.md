# Market Active Item Server
Simple Spring Boot API providing CRUD functionality for items listed in an online marketplace. 

The basic premise is a craigslist / facebook marketplace clone. This repository is for a service that only deals with items currently available to see through the public interface. Historical data will be handled by a separate service, to keep everything narrowly focused. 

Database integration is done by having the Spring Context inject an adapter to an in-memory H2 database. I chose this because 

A) It is one fewer dependency for an example project, as the intention is to make it work for a demo and not a production system 
B) I won't have to worry about unintentionally having DB credentials in a public repository 
C) It is a pretty easy process 
