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


    open class Animal(
        var age: Int,
        var name: String = "name",
        var sex: String? = "123123123"
    ) {

    }

    class Dog(age: Int) : Animal(age) {
        var test: Long = 0;
    }


    @Test
    fun asdfasdf() {
        val dog1 = Dog(age = 13)
        dog1.name = "바뀐내임"
        dog1.sex = "tㅔㄱ스"
        dog1.test = 123123123
        println(dog1.test)
        println(dog1.age)
        println(dog1.name)
        println(dog1.sex)
    }


}