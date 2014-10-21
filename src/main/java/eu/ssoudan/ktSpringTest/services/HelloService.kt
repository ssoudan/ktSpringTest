package eu.ssoudan.ktSpringTest.services

/**
 * Created by ssoudan on 10/21/14.
 *
 * APLv2
 */
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import kotlin.properties.Delegates
import org.slf4j.Logger
import rx.Observable
import rx.lang.kotlin.asObservable

val lazyLogger: Logger? by Delegates.lazy {
    println("computed!")
    LoggerFactory.getLogger(javaClass<HelloService>())
}


Service
public class HelloService() {

    public fun getSomething(): Observable<Long>? {

        return listOf(1L, 2L, 3L).asObservable().filter { it != null && 2L <= it }
    }

}

