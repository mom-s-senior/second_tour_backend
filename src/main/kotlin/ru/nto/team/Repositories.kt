package ru.nto.team

import jakarta.persistence.Id
import org.springframework.data.jpa.repository.JpaRepository

// TODO: extend JpaRepository only after the corresponding JPA model is connected.
// These interfaces are intentionally not active Spring Data repositories yet.
interface StaffRepository : JpaRepository<Staff, Long> {
    fun findByCode(code: String): Staff?
}

interface PassRequestRepository : JpaRepository<PassRequest, Long> {
    fun findByHost(host: Staff): List<PassRequest>

    fun findByHostAndStatus(
        host: Staff,
        status: RequestStatus,
    ): List<PassRequest>
}