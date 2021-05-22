package com.example.kotlindemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.scheduling.annotation.EnableAsync

@EnableJpaAuditing
@SpringBootApplication
@EnableAsync
class KotlinDemoApplication
fun main(args: Array<String>) {
    runApplication<KotlinDemoApplication>(*args)
}

