package com.example.kotlindemo

import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun kotlin() {
        Student(name = "john", id = 500)
    }

    class Student(var name: String, var id: Int =0) {
        constructor(name: String) : this(name, 100) {
            println("constructor block :: name is $name and id is $id")
        }

        init {
            name ="kim"
            println("init block :: name is $name and id is $id")
        }
    }
}