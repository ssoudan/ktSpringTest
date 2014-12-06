package eu.ssoudan.ktSpringTest.management

import java.util.LinkedList
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.annotation.JsonIgnore

/**
 * Created by ssoudan on 12/6/14.
 *
 * Apache License, Version 2.0
 */
trait HealthCheckedService {

    enum class HealthStatus {
        UP
        DOWN
    }

    JsonInclude(Include.NON_EMPTY)
    data class HealthInfo(JsonIgnore val service: HealthCheckedService, var status: HealthStatus) {

        val dependencies: MutableList<HealthInfo> = LinkedList()

        val serviceName = service.javaClass.getSimpleName()

        fun addDependency(healthInfo: HealthInfo): HealthInfo {
            dependencies.add(healthInfo)
            return this
        }

        fun addDependency(service: HealthCheckedService): HealthInfo {
            dependencies.add(service.healthCheck())
            return this
        }

        fun updateStatus() {
            for (dep in dependencies) {
                dep.updateStatus()
                if (dep.status == HealthStatus.DOWN) {
                    this.status = HealthStatus.DOWN;
                }
            }
        }

    }

    fun healthCheck(): HealthInfo

}