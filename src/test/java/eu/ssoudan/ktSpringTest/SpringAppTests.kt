package eu.ssoudan.ktSpringTest

/**
 * Created by ssoudan on 10/21/14.
 *
 * Apache License, Version 2.0
 */
import eu.ssoudan.ktSpringTest.services.HelloService
import junit.framework.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.support.AnnotationConfigContextLoader

RunWith(javaClass<SpringJUnit4ClassRunner>())
ComponentScan(array("eu.ssoudan"))
EnableAutoConfiguration
ContextConfiguration(classes = array(javaClass<HelloService>()), loader = javaClass<AnnotationConfigContextLoader>())
public class SpringAppTests() {

    Autowired
    public var helloService: HelloService = HelloService()

    Test
    public fun testGetSomething() {

        Assert.assertEquals(arrayListOf(2L, 3L), helloService.getSomething()?.toBlocking()?.toIterable()?.sort())
    }

}
