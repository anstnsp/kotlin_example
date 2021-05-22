package com.example.kotlindemo.web.report

import com.example.kotlindemo.web.base.BaseController
import com.example.kotlindemo.common.Log
import com.example.kotlindemo.web.report.dto.ReportRequest

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@BaseController
class ReportController(
    private val reportService: ReportService
) {

    companion object : Log

    @PostMapping("/report")
    fun create(
        @RequestBody reportRequest: ReportRequest
    ) {
        logger.info("request : $reportRequest")
        reportService.create(reportRequest)

    }
}