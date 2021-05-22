package com.example.kotlindemo.domain.report

import com.example.kotlindemo.domain.AuditEntity
import com.example.kotlindemo.web.report.dto.ReportType
import javax.persistence.*

@Entity
@Table(name = "reports")
class Report(userId: Long,postId: Long, reportType: ReportType, reason: String?) : AuditEntity() {


    @Column(name = "post_id")
    val postId: Long = 0L

    @Column(name = "reply_id")
    val replyId: Long? = null

    @Column(name = "user_id", nullable = false)
    val userId: Long = userId

    @Column(name = "report_type", nullable = false)
    @Enumerated(EnumType.STRING)
    val reportType: ReportType = reportType

    @Column(name = "reason")
    var reason: String? = reason
        protected set

    fun addReason(reason: String) {
        this.reason = reason
    }

}