package ru.nto.team

import jakarta.persistence.*
import java.time.LocalDateTime

// TODO: JPA entity for pass_request, including a staff association and generated Long ID.
// No @Entity yet: the unfinished model must not prevent application startup.
@Entity
@Table(name = "pass_request")
class PassRequest(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_id", nullable = false)
    var host: Staff,

    @Column(nullable = false)
    var fullName: String,

    @Column(nullable = false)
    var phone: String,

    @Column
    var organization: String?,

    @Column(nullable = false)
    var purpose: String,

    @Column(name = "valid_from", nullable = false)
    var validFrom: LocalDateTime,

    @Column(name = "valid_to", nullable = false)
    var validTo: LocalDateTime,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var status: RequestStatus,

    @Column
    var comment: String?,

    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime,

    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime,
)
