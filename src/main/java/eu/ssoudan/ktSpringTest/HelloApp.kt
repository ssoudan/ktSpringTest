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
import org.springframework.context.annotation.PropertySources
import org.springframework.context.annotation.PropertySource
import eu.ssoudan.ktSpringTest.configuration.GlobalConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.slf4j.Logger
import kotlin.properties.Delegates
import org.slf4j.LoggerFactory
import eu.ssoudan.ktSpringTest.services.HelloService

ComponentScan
EnableAutoConfiguration
PropertySource(value = array("classpath:/application.properties", "file:/etc/myapp.properties"))
public class HelloApp : SpringBootServletInitializer() {

    protected override fun configure(application: SpringApplicationBuilder?): SpringApplicationBuilder? {
        application?.sources(javaClass<HelloApp>())
        super.configure(application)
        return application
    }
}

fun main(args: Array<String>) = SpringApplication.run(array(javaClass<HelloApp>()), args)


