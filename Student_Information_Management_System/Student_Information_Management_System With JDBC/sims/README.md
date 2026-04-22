# Student Information Management System (SIMS)
Spring Boot 3.2.5 | Java 17 | Lombok | H2 | Thymeleaf

## Prerequisites
- Java 17 or higher (check: java -version)
- VS Code with "Extension Pack for Java" by Microsoft

## Run in VS Code
1. Extract ZIP and open the `sims` folder in VS Code
2. Install Extension Pack for Java if prompted
3. Wait for Maven to download dependencies (~1-2 min first time)
4. Press F5  OR  open SimsApplication.java and click the Run button
5. Visit: http://localhost:8080

## Run from Terminal
  cd sims
  mvn spring-boot:run

## H2 Console (inspect database in browser)
  URL:      http://localhost:8080/h2-console
  JDBC URL: jdbc:h2:mem:simsdb
  Username: sa
  Password: (leave blank)
