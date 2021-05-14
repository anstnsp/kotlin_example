package com.example.kotlindemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class TestController {
    
    @GetMapping("/hello")
    fun hello(): String {
        return "hello"
    }

    @PostMapping("/post")
    fun post(
        @RequestBody @Valid site: Site
    ): Site {
        site.title = "바뀜"
        println(site.title)
        println("wfwef")

        println("wfwef")
        return site;
    }
}