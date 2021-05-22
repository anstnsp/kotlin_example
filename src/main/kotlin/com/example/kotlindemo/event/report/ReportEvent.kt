package com.example.kotlindemo.event.report

import com.example.kotlindemo.web.report.dto.ReportType

class ReportEvent(
     val userId: Long,
     val postId: Long,
     val reportType: ReportType,
     val reason: String?
)