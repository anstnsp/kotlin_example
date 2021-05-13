package com.example.kotlindemo

import java.util.*

/**
 * companion을 통한 java 에서 static키워드 대체 하기
 *
 */
class MyClass {
    companion object {
        val TAG = "tag1";
        fun createFiles() {
            println("created file")
        }
    }
}
