package eu.ssoudan.ktSpringTest.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.beans.factory.annotation.Value

/**
 * Created by ssoudan on 10/21/14.
 *
 * Apache License, Version 2.0
 */
Configuration
open class HelloConfiguration() {

    Value("\${ktSpringTest.test:notDefined}")
    var testProperties: String = ""

}