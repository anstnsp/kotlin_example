package com.example.kotlindemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class KotlinDemoApplication
fun main(args: Array<String>) {
    runApplication<KotlinDemoApplication>(*args)
}

