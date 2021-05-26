package com.example.kotlindemo.annotation


@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Logging(
    val required: Boolean = false
)