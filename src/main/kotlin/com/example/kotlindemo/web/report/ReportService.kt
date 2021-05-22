package com.example.kotlindemo.web.report

import com.example.kotlindemo.common.Log
import com.example.kotlindemo.domain.report.ReportRepository
import com.example.kotlindemo.event.report.ReportEvent
import com.example.kotlindemo.web.report.dto.ReportRequest
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionSynchronizationManager

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
        logger.info("서비스쪽 트랜잭션이름  : ${TransactionSynchronizationManager.getCurrentTransactionName()}")
        logger.info("서비스쪽 스레드이름 : ${Thread.currentThread().name}")
        eventPublisher.publishEvent(reportRequest.toEvent())  //신고이벤트 발행.

        logger.info("이벤트 발행 후 ")
        Thread.sleep(4000)
        logger.info("슬립 4초지남. 이 로그가 찍혀야 create트랜잭션이 끝나고 이벤트리스너의 함수가 실행됨.")
    }
}