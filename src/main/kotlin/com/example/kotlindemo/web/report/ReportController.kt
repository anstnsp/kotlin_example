package com.example.kotlindemo.web.report

import com.example.kotlindemo.annotation.Logging
import com.example.kotlindemo.web.base.BaseController
import com.example.kotlindemo.common.Log
import com.example.kotlindemo.domain.report.Report
import com.example.kotlindemo.web.report.dto.ReportRequest
import org.springframework.web.bind.annotation.*

@BaseController
class ReportController(
    private val reportService: ReportService
) {

    companion object : Log

    @Logging
    @PostMapping("/report")
    fun create(
        @RequestBody reportRequest: ReportRequest
    ) : String {
        reportService.create(reportRequest)
        println("sfsf")
        return "success111"
    }

    @Logging
    @GetMapping("/report/{reportId}")
    fun findById(
        @PathVariable reportId: Long
    ): Report {

        return reportService.findReportOne(reportId)
    }
}
