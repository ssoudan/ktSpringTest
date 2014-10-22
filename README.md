ktSpringTest
============

Basic Spring Boot app in Kotlin


# Notes

We are using a trampoline class in Java to help spring find the main method.
Because of that, the pom is set to compile Kotlin  code before Java code by running the Kotlin compilation in the `process-sources` phase.

# Build

    $ mvn clean package

# Run

    $ mvn spring-boot:run

or

    $ java -jar target/SpringApp.jar