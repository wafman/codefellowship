# Lab 16: Spring for Full-Stack Web Apps with Autentication

## Description
- create a spring full stack application with user authentication. 
- create ability of users to signup/login for Code Fellowship
- allow users to be able to create posts
- allow users to be able to see posts they've created

## API
- ```@GetMapping("/")```
  - redirects to login
- ```@GetMapping("/login")```
  - presents an html page with a form to login 
- ```@GetMapping("/signup")```
  - presents an html page with a form to signup
- ```@GettMapping("/myprofile") ```
  - user gets redirected to their page when signing up or logging in
  - users can see their own posts
- ```@GetMapping("/users")```
  - logged in users can see all users
- ```@GetMapping("/details/{id}")```
  - logged in users can see details of users
- ```@GetMapping("/error")```
  - handles all errors without showing stack trace to user
- ```@PostMapping("/create/post")```
  - gives the users the ability to create posts
- ```@PostMapping("/follow/{id}")```
  - gives uers the ability to follow other users
- ```@GetMapping("/feed")```
  - gives users the ability to see the posts of users they follow.



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
      - ```localhost:8080/myprofile```
      - ```localhost:8080/users```
      - ```localhost:8080/details/{id}```
      - ```localhost:8080/create/post```
      - ```localhost:8080/feed```
 
 ## Acknowledgements
 - [Geeks for Geeks](https://www.geeksforgeeks.org/java/)
  - general java guidance
 - [Stack Abuse](https://stackabuse.com/how-to-get-current-date-and-time-in-java/)
  - local datetime examples and explanations
 - [Pure CSS](https://purecss.io/forms/)
  - basic css styling