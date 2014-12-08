ktSpringTest
============

Basic Spring Boot app in Kotlin

You can read more about it [here](http://ssoudan.eu/posts/2014-12-08-kotlin-springboot.html) on my blog.

# Notes

We are using a trampoline class in Java to help spring find the main method.
Because of that, the pom is set to compile Kotlin  code before Java code by running the Kotlin compilation in the `process-sources` phase.

# Build

    $ mvn clean package

# Run

    $ mvn spring-boot:run

or

    $ java -jar target/SpringApp.jar
