package eu.ssoudan.ktSpringTest.controllers

/**
 * Created by ssoudan on 10/21/14.
 */
import org.springframework.stereotype.Controller
import eu.ssoudan.ktSpringTest.services.HelloService
import eu.ssoudan.ktSpringTest.configuration.HelloConfiguration
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired

Controller
public class HelloController[Autowired] (val helloService: HelloService, val helloConfiguration: HelloConfiguration) {

    RequestMapping(array("/"), method = array(RequestMethod.GET))
    ResponseBody
    fun get(): String {
        val observable = helloService.getSomething()?.toBlockingObservable()
        var msg = ""
        observable?.forEach { msg += "${it} " }
        val value = "GET / -> ${helloConfiguration.testProperties} - ${msg}"
        println(value)
        return value
    }

}