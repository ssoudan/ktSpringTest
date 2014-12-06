package eu.ssoudan.ktSpringTest.management

import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.AbstractHealthIndicator
import org.springframework.stereotype.Service
import eu.ssoudan.ktSpringTest.management.HealthCheckedService.HealthStatus
import java.util.LinkedList
import eu.ssoudan.ktSpringTest.configuration.HelloConfiguration
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by ssoudan on 12/6/14.
 *
 * Apache License, Version 2.0
 */
Service
class ServiceHealthIndicator [Autowired] (val services: List<HealthCheckedService>,
                                          val configuration: HelloConfiguration) : AbstractHealthIndicator() {

    fun updateStatus(status: HealthStatus, dependencies: List<HealthCheckedService.HealthInfo>): HealthStatus {
        var updatedStatus = status;
        dependencies.forEach { dep ->
            dep.updateStatus()
            if (dep.status == HealthStatus.DOWN) {
                updatedStatus = HealthStatus.DOWN;
            }
        }
        return updatedStatus
    }

    override fun doHealthCheck(p0: Health.Builder?) {

        if (p0 != null) {
            val dependencies = LinkedList<HealthCheckedService.HealthInfo>()
            services.forEach { i -> dependencies.add(i.healthCheck()) }

            val status = updateStatus(HealthStatus.UP, dependencies)

            p0.withDetail("dependencies", dependencies)
            p0.withDetail("serviceName", configuration.serviceName)

            if (status == HealthStatus.UP)
                p0.up()
            else
                p0.down()
        }
    }

}