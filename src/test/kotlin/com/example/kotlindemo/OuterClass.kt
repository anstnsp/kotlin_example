package com.example.kotlindemo

class OuterClass {
    val outerValue = 10
    class StaticNestedClass {
        private val innerValue = 20
        fun printItems() {
            println("innerValue : $innerValue");
        }
    }
}

fun main(args: Array<String>) {
    val nested = OuterClass.StaticNestedClass();
    nested.printItems();
}