# one-time-token-app

Simple desktop application for: 
  * public access token generation
  * sending this one on a client email
  * verification this one via REST API
 
## Technologies
* Java 17
* Java FX 19
* Spring Boot 3
* Maven
* Git
* Spring Data 
* MongoDB 

## How to launch one-time-token-app

There are two ways. The first one:  
1. Build an application by command:

    `mvn install` 

2. Find executable jar in target directory
_/one-time-token-app/target/one-time-token-app-1.0.0-SNAPSHOT-exec.jar_
3. Run it by double clicking 

The second one: 
1. Run application in **javafx-maven-plugin** 

    `mvn javafx:run`
## Mongo DB connection
The application's db located in the cloud cluster. You can monitor it for example by MongoDB Compass and following connection string:
`mongodb+srv://token-app-user:<password>@cluster0.ttii4dh.mongodb.net/`

* db_name = token_db
* collection = token
