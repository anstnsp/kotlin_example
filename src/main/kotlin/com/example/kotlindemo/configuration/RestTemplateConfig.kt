package com.example.kotlindemo.configuration

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.BufferingClientHttpRequestFactory
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.web.client.RestTemplate
import java.time.Duration

@Configuration
class RestTemplateConfig {

    @Bean
    fun restTemplate(): RestTemplate {
         return restTemplateBuilder()
            .setConnectTimeout(Duration.ofSeconds(30))
            .setReadTimeout(Duration.ofSeconds(30))
            .build()
    }

    @Bean
    fun restTemplateBuilder(): RestTemplateBuilder {
        return RestTemplateBuilder()
            .requestFactory { BufferingClientHttpRequestFactory(SimpleClientHttpRequestFactory()) }
            .setConnectTimeout(Duration.ofSeconds(30L))
            .setReadTimeout(Duration.ofSeconds(30L))
    }

}