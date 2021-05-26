package com.example.kotlindemo.aop

import com.example.kotlindemo.common.Log
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Component
@Aspect
class LogAspect {

    companion object : Log


    @Around("@annotation(com.example.kotlindemo.annotation.Logging)")
    fun logging(jointPoint: ProceedingJoinPoint): Any? {
        logger.debug("Start - ${jointPoint.signature.declaringTypeName} / ${jointPoint.signature.name}")
        val result = jointPoint.proceed()
        logger.debug("Finished - ${jointPoint.signature.declaringTypeName} / ${jointPoint.signature.name}")
        return result
    }
}