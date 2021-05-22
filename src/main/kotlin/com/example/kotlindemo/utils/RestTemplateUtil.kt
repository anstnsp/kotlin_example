package com.example.kotlindemo.utils

import com.example.kotlindemo.common.Log
import org.slf4j.LoggerFactory
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class RestTemplateUtil(
    val restTemplate : RestTemplate
) {

    companion object : Log


    fun post(url: String, body: Any) {
        val header = HttpHeaders()
        header.contentType = MediaType.APPLICATION_JSON
        header.accept = listOf(MediaType.APPLICATION_JSON)
        val request = HttpEntity<Any>(body, header)
        try {
            restTemplate.postForLocation(url, request)
        } catch (e: Exception) {
            logger.error("slack 통신에러", e)
        }
    }
}