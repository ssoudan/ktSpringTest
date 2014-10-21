package eu.ssoudan.ktSpringTest

/**
 * Created by ssoudan on 10/21/14.
 *
 * Apache License, Version 2.0
 */
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.web.SpringBootServletInitializer


ComponentScan
EnableAutoConfiguration
public class HelloApp : SpringBootServletInitializer() {

    protected override fun configure(application: SpringApplicationBuilder?): SpringApplicationBuilder? {
        application?.sources(javaClass<HelloApp>())
        super.configure(application)
        return application
    }
}

fun main(args: Array<String>) = SpringApplication.run(array(javaClass<HelloApp>()), args)


