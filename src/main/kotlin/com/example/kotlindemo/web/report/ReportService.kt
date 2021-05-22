package com.example.kotlindemo.web.report

import com.example.kotlindemo.common.Log
import com.example.kotlindemo.domain.report.ReportRepository
import com.example.kotlindemo.event.report.ReportEvent
import com.example.kotlindemo.web.report.dto.ReportRequest
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReportService(
    private val reportRepository: ReportRepository,
    private val eventPublisher: ApplicationEventPublisher
) {

    companion object : Log

    @Transactional
    fun create(reportRequest: ReportRequest) {
        logger.info("report service")

        reportRepository.save(reportRequest.toEntity()) //신고가 접수되서 디비에 저장.
        //sendSlackMsg() //슬랙에 메세지 보냄.
        eventPublisher.publishEvent(reportRequest.toEvent())  //신고이벤트 발행.

    }
}