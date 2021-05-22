package com.example.kotlindemo.event.report

import com.example.kotlindemo.common.Log
import com.example.kotlindemo.utils.RestTemplateUtil
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class ReportEventHandler(
    private val restTemplateUtil: RestTemplateUtil
) {
    companion object : Log

    @Value("\${slack.reportUrl}")
    private lateinit var slackUrl : String


    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun reportEventListener(event: ReportEvent) {
        logger.debug("onReportEvent: $event")
        with(event) {
            val msg = "{\n  \"text\":  " +
                    "\"*[게시물이 신고 되었씁니다.]* \n" +
                    "신고한게시물번호: ${event.postId}\"" +
                    "}"
            restTemplateUtil.post(slackUrl, msg)
        }

    }

}