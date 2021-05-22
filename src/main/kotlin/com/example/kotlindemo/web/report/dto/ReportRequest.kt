package com.example.kotlindemo.web.report.dto

import com.example.kotlindemo.domain.report.Report
import com.example.kotlindemo.event.report.ReportEvent

data class ReportRequest(
    private val userId: Long,
    private val postId: Long,
    private val reportType: ReportType,
    private val reason: String?
) {

    fun toEntity(): Report {
        return Report(userId, postId, reportType, reason)
    }

    fun toEvent(): ReportEvent {
        return ReportEvent(userId, postId, reportType, reason)
    }
}

enum class ReportType (
    val description: String
) {
    // 영리목적/홍보
    SPAM("스팸"),

    //불법정보
    ILLEGAL_INFO("불법정보"),

    // 기타
    ETC("기타")
}