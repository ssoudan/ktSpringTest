package eu.ssoudan.ktSpringTest.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

/**
 * Created by ssoudan on 12/06/14.
 *
 * Apache License, Version 2.0
 */
Configuration
Component
open class GlobalConfiguration() {

    Value("\${global.foo:blah}")
    public var globalFoo: String = ""

}