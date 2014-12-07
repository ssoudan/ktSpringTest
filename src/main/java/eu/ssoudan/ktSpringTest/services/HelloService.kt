package eu.ssoudan.ktSpringTest.services

import org.springframework.stereotype.Service
import org.slf4j.Logger
import kotlin.properties.Delegates
import org.slf4j.LoggerFactory
import rx.Observable
import rx.lang.kotlin.asObservable
import eu.ssoudan.ktSpringTest.management.HealthCheckedService
import eu.ssoudan.ktSpringTest.management.HealthCheckedService.HealthInfo
import org.springframework.beans.factory.annotation.Autowired
import eu.ssoudan.ktSpringTest.configuration.GlobalConfiguration
import org.springframework.boot.actuate.metrics.Metric
import java.util.concurrent.atomic.AtomicInteger
import org.springframework.boot.actuate.metrics.writer.MetricWriter
import org.springframework.boot.actuate.metrics.writer.Delta

/**
 * Created by ssoudan on 10/21/14.
 *
 * Apache License, Version 2.0
 */
val lazyLogger: Logger by Delegates.lazy {
    val logger = LoggerFactory.getLogger(javaClass<HelloService>())!!
    println("logger initialized!")
    logger
}


Service
public class AnotherService [Autowired] (val globalConfiguration : GlobalConfiguration) : HealthCheckedService {

    override fun healthCheck(): HealthCheckedService.HealthInfo {
        return HealthInfo(this, HealthCheckedService.HealthStatus.UP)
    }

    public fun doSomething(): Observable<Long> {
        lazyLogger.info("and here! ${globalConfiguration.globalFoo}");
        return listOf(1L, 2L, 3L).asObservable()
    }

}

Service
public class HelloService [Autowired] (val metricWriter: MetricWriter, val otherService : AnotherService ) : HealthCheckedService {

    override fun healthCheck(): HealthCheckedService.HealthInfo {
        return HealthInfo(this, HealthCheckedService.HealthStatus.UP).addDependency(otherService)
    }

    public fun getSomething(): Observable<Long> {
        lazyLogger.info("i'm here!");
        metricWriter.increment(Delta("hello.service.call.count", 1));
        return otherService.doSomething().filter { it != null && 2L <= it } as Observable<Long>
    }

}

