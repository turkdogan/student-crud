# Introduction
A simple Student CRUD project to represent the integrations of Spring, PrimeFaces and HSQLDB. 

The view tier (JSF) interacts JSF controllers directly. Controllers injects and uses Spring based services and uses database indirectly through Spring services. Database connections are carried out by using Spring Repository Beans.

# Running the Application
Execute following commands to run the application:
- mvn clear
- mvn compile
- mvn package
- mvn test (executes unit and integration tests)
- mvn jetty:run (runs application on embedded jetty server)

# Notes
- The maven is configured to run on Jetty server.
- Please not that, every time the server runs, the database is initialized.

# Possible implementations
- Authentication/Authorization
- UTF-8 Encoding
- Locale configurations
- Better styling
