# Lab 16: Spring for Full-Stack Web Apps with Autentication

## Description
- create a spring full stack application with user authentication. 

## API
- ```@GetMapping("/")```
  - redirects to login
- ```@GetMapping("/login")```
  - presents an html page with a form to login 
- ```@GetMapping("/signup")```
  - presents an html page with a form to signup



## Directions
- from IntelliJ
  - open application
  - run the App.java
- from Command Line
  - test
    - ```./gradlew test```
  - Start Server
    - ```./gradlew bootRun```
    - proceeed in broswer to following routes
      - ```localhost:8080/```
      - ```localhost:8080/login```
      - ```localhost:8080/signup```
 