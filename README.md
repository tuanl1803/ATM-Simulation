# ATM-Simulation
ATM Simulation
Spring Boot, MySQL, JPA, Hibernate Rest API
Build a simple ATM application using Spring Boot, Mysql, JPA and Hibernate.

Requirements
Java - 1.8.x

Maven - 4.x.x

Mysql - 5.x.x
Steps to Setup
1. Clone the application
2. Create Mysql database
create database atm
3. Change mysql username and password as per your installation
   - Open src/main/resources/application.properties
   - Change spring.datasource.username and spring.datasource.password as per your mysql installation
4. Build and run the app using maven
  mvn spring-boot:run
  You can login with AccNo : 123456 and PIN : 123456
The app will start running at http://localhost:8080.