package com.example.kotlindemo.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0L

    @CreatedDate
    @Column(name = "created_at", updatable = true, nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @Column(name = "updated_at", updatable = true, nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()

    @Column(name = "deleted_at", updatable = true, nullable = true)
    var deletedAt: LocalDateTime? = null
}
