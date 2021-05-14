package com.example.kotlindemo

open class Animal(val age: Int, val name: String, val sex: String?) {

}

class Dog(age: Int, name: String, sex: String?) : Animal(age, name, sex) {

}
