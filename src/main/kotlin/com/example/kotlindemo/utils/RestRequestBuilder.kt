package com.example.kotlindemo.utils

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.http.RequestEntity
import org.springframework.stereotype.Component
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@Component
class RestRequestBuilder {

    companion object{
        /**
         * GET 요청을 위한 RequestEntity를 생성한다.
         * */
        fun getRequest(url: String, path: String): RequestEntity<String> {
            val header = HttpHeaders().apply {
                contentType = MediaType.APPLICATION_JSON
            }

            return RequestEntity(
                header,
                HttpMethod.GET,
                URI.create("$url$path")
            )
        }

        /**
         * GET 요청을 위한 RequestEntity를 생성한다.
         * */
        fun getRequest(url: String, builder: UriComponentsBuilder): RequestEntity<String> {
            val header = HttpHeaders().apply {
                contentType = MediaType.APPLICATION_JSON
            }
            return RequestEntity(
                header,
                HttpMethod.GET,
                URI.create("$url${builder.toUriString()}")
            )
        }

        /**
         * POST 요청을 위한 RequestEntity를 생성한다.
         */
        fun postRequest(url: String, builder: UriComponentsBuilder): RequestEntity<String> {
            val header = HttpHeaders().apply {
                contentType = MediaType.APPLICATION_JSON
            }
            return RequestEntity(
                header,
                HttpMethod.POST,
                URI.create("$url${builder.toUriString()}")
            )
        }

        /**
         * POST 요청을 위한 RequestEntity를 생성한다.
         */
        fun postRequest(url: String, body: Any): RequestEntity<Any> {
            val header = HttpHeaders().apply {
                contentType = MediaType.APPLICATION_JSON
            }
            return RequestEntity(
                body,
                header,
                HttpMethod.POST,
                URI.create("$url")
            )
        }

        /**
         * DELETE 요청을 위한 RequestEntity를 생성한다.
         * */
        fun deleteRequest(url: String, builder: UriComponentsBuilder): RequestEntity<String> {
            val header = HttpHeaders().apply {
                contentType = MediaType.APPLICATION_JSON
            }
            return RequestEntity(
                header,
                HttpMethod.DELETE,
                URI.create("$url${builder.toUriString()}")
            )
        }

    }

}