package com.example.kotlindemo

/**
 * val을 쓰면 읽기전용 프로퍼티로 private필드와 getter를 만든다.
 * var를 쓰면 private필드와 getter,setter를 만든다.
 * 주의할 것은 is로 시작하는 프로퍼티를 지정하면 이름 그대로의 메소드가 만들어진다.
 * 그리고 getter setter의 사용은 함수를 호출하지 않고 그냥 .으로 사용
 * person.name  (게터호출)
 * person.age   (게터호출)
 * person.isMarried = true (세터호출) 이런식..
 */
class Person(val name:String, val age:Int, var isMarried:Boolean) {
    constructor(name:String) : this(name, 0, true)
}