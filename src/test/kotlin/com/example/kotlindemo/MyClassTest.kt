//package com.example.kotlindemo
//
//import org.junit.jupiter.api.Test
//
//class MyClassTest {
//
//    @Test
//    fun companion_test() {
//        println(MyClass.TAG)
//        MyClass.createFiles()
//    }
//
//    @Test
//    fun printlnFibo() {
//        println("fibonacci : ${fibonacciLoop(10)}")
//        println("recur ${recurFibo(10, 1,1)}")
//    }
//
//    @Test
//    fun factorial() {
//        println(factorialLoop(3));
//        println(recurFactorial(3, 1))
//    }
//
//    private fun fibonacciLoop(n: Int): Int {
//        var first = 1;
//        var second = 1;
//        return when (n) {
//            1 -> first
//            2 -> second
//            else -> {
//                var current = first + second;
//                for (num in 3..n) {
//                    current = first + second;
//                    first = second;
//                    second = current;
//                }
//                current;
//            }
//        }
//    } // fibo
//
//    private tailrec fun recurFibo(n: Int, first: Int, second: Int): Int {
//        return if (n <= 1) {
//            first
//        } else {
//            recurFibo(n-1, second, first + second)
//        }
//    } //recurFibo
//
//    private fun factorialLoop(n: Int): Int {
//        var acc = 1;
//        for (number in 1..n) {
//            acc *= number;
//        }
//        return acc;
//    }
//
//    private tailrec fun recurFactorial(n: Int, acc: Int): Int {
//        return if (n <= 1) {
//            acc
//        } else {
//            recurFactorial(n-1, n*acc)
//        }
//    }
//}