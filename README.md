# Introduction
A simple Student CRUD project to represent the integrations of Spring, PrimeFaces and HSQLDB. 

The view tier (HTML/JSF) interacts JSF controllers directly. Controllers inject and use Spring based services, reach database indirectly through Spring services. Database connections are performed by using Spring Repository Beans.

# Running the Application
Execute following commands to run the application:
```
mvn clear
mvn compile
mvn package
mvn test (executes unit and integration tests)
mvn jetty:run (runs application on embedded jetty server)
```

# Notes
- The maven is configured to run on Jetty server.
- Please not that, every time the server runs, the database is initialized.

# Possible implementations
- Authentication/Authorization
- UTF-8 Encoding
- Locale configurations
- Better styling
