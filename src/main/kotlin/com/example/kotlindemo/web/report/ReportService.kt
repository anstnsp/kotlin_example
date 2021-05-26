package com.example.kotlindemo.web.report



import com.example.kotlindemo.annotation.Logging
import com.example.kotlindemo.common.Log
import com.example.kotlindemo.domain.report.Report
import com.example.kotlindemo.domain.report.ReportRepository
import com.example.kotlindemo.web.report.dto.ReportRequest
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionSynchronizationManager

@Transactional
@Service
class ReportService(
    private val reportRepository: ReportRepository,
    private val eventPublisher: ApplicationEventPublisher
) {

    companion object : Log


    @Logging
    fun create(reportRequest: ReportRequest) {
        reportRepository.save(reportRequest.toEntity()) //신고가 접수되서 디비에 저장.
        logger.info("서비스쪽 트랜잭션이름  : ${TransactionSynchronizationManager.getCurrentTransactionName()}")
        logger.info("서비스쪽 스레드이름 : ${Thread.currentThread().name}")
        eventPublisher.publishEvent(reportRequest.toEvent())  //신고이벤트 발행.
        logger.info("이벤트 발행 후 ")

    }

    @Logging
    @Cacheable(cacheManager = "localCacheManager", cacheNames = ["test"], key = "#id" ,condition = "#id < 3" )
    fun findReportOne(id: Long): Report {
        return reportRepository.findById(id).orElseThrow { IllegalStateException("없어") }
    }

    @CacheEvict(cacheManager = "localCacheManager", cacheNames = ["test"], key = "#id")
    fun void() {
        logger.info("키가 findReportCache인 캐시 제거")
    }


}


