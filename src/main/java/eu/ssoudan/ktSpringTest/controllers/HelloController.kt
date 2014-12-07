package eu.ssoudan.ktSpringTest.controllers

/**
 * Created by ssoudan on 10/21/14.
 *
 * Apache License, Version 2.0
 */
import org.springframework.stereotype.Controller
import eu.ssoudan.ktSpringTest.services.HelloService
import eu.ssoudan.ktSpringTest.configuration.HelloConfiguration
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired

RestController
public class HelloController [Autowired] (val helloService: HelloService, val helloConfiguration: HelloConfiguration) {

    RequestMapping(array("/"), method = array(RequestMethod.GET))
    fun get(RequestParam("blah", required = false) blah : String?): String {

        val observable = helloService.getSomething().toBlocking()
        var msg = "${blah} "
        observable?.forEach { msg += "${it} " }

        val value = "GET / -> ${helloConfiguration.testProperties} - ${msg}"

        return value
    }

}