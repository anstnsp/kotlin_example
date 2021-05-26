package com.example.kotlindemo.event.report

import com.example.kotlindemo.common.Log
import com.example.kotlindemo.utils.RestRequestBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener
import org.springframework.transaction.support.TransactionSynchronizationManager
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.exchange

@Component
@EnableAsync
class ReportEventHandler(
    private val restTemplate: RestTemplate
) {
    companion object : Log

    @Value("\${slack.reportUrl}")
    private lateinit var slackUrl : String


    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun reportEventListener(event: ReportEvent) {
        logger.info("이벤트시작됨... 7초대기 후 실행!")
        Thread.sleep(7000)
        logger.info("onReportEvent: $event")
        logger.info("이벤트핸들러쪽 트랜잭션이름  : ${TransactionSynchronizationManager.getCurrentTransactionName()}")
        logger.info("이벤트핸들러쪽 스레드이름 : ${Thread.currentThread().name}")
        with(event) {
            val msg = "{\n  \"text\":  " +
                    "\"*[게시물이 신고 되었습니다.]* \n" +
                    "신고한게시물번호 : $postId \n" +
                    "신고한유저아이디 : $userId \n" +
                    "신고타입 : $reportType \n"  +
                    "신고한이유 : $reason \""     +
                    "}"

            val response: ResponseEntity<String> = restTemplate.exchange(RestRequestBuilder.postRequest(slackUrl, msg))
            logger.info("응답상태코드 : ${response.statusCode}")
            logger.info("응답바디 : ${response.body}")
            logger.info("응답전문 : $response")
            if (response.statusCode != HttpStatus.OK) {
                logger.error("failed to send message to slackChannel")
            }

        }
        logger.info("[Success] : 슬랙 메세지 전송 성공!!")
    }

}