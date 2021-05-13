//package com.example.kotlindemo
//
//import org.junit.jupiter.api.Test
//import java.lang.RuntimeException
//import java.lang.StringBuilder
//
//class SiteTest {
//
//    @Test
//    fun data_class_copy_test() {
//        val site1 = Site("anstnsp.com", "title1")
//        val copySite = site1.copy(title = "copy title")
//
//        println(site1)
//        println(copySite)
//    }
//
//    @Test
//    fun destructuring_test() {
//        //분해선언은 생성자에 정의된 프로퍼티의 순서대로 변수에 대입합니다.
//        //일반클래스에서도 분해선언은 가능하지만 componentN() 메소드를 직접 구현해줘야 한다.
//        val site1 = Site("naver.com", title="nice to meet u")
//        val (url, title) = site1
//
//        println("url : $url")
//        println("title : $title")
//
//        val string = "testestst";
//        if (string is String)
//            println(string.toUpperCase())
//    }
//
//    @Test
//    fun expression_statement() {
//        println(max1(3,5))
//        println(max2(3,5))
//        println(max3(3,5))
//        for (i in 1..10) {
//            println(i)
//        }
//        val map = mutableMapOf("a" to "jdk")
//        map["b"] = "hello" // map.put("b", "hello") 와같음.
//        println(map["b"])
//        for( (key, value) in map) {
//            println("$key = $value")
//        }
//        val originMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
//        val filteredMap = originMap.filterNot { it.value < 3 }
//        println("filteredMap : $filteredMap")
//        println("originMap : $originMap")
//
//    }
//    @Test
//    fun when_test() {
//        cases(1)
//        cases("hello")
//        cases(0L)
//        cases("aslkdfklamdf")
//    }
//    private fun cases(obj: Any) {
//        when (obj) {
//            1 -> println("one")
//            "hello" -> println("greeting")
//            is Long -> println("Long")
//            !is String -> println("Not a String")
//            else -> println("Unknown")
//        }
//    }
//
//    @Test
//    fun with_test() {
//        val result = with(StringBuilder()) {
//                        for (letter in 'A'..'Z') {
//                            append(letter)
//                        }
//                        append("\nNow i know the alphabet!")
//                        println(toString())
//                        toString()
//                    }
//       println("result : $result")
//    }
//
//
//    @Test
//    fun let_test() {
//        /**
//         * let()
//         * let()은 함수를 호출하는 객체를 이어지는 블록의 인자로 넘기고
//         * 블록의 결과값을 반환합니다.
//         *
//         * 그러므로 let은 어떠한 값이나 객체를 갖고 이를 이용해 다른메소드를 수행하거나
//         * 연산을 해야 할 때 사용 한다.
//         *
//         * fun <T,R> T.let(block: (T) -> R): R
//         * fun <T,R> T.run(block: T.() -> R): R
//         *
//         * 함수를 호출한 객체를 인자로 받으므로, 이를 사용하여 다른 메서드를 실행하거나
//         * 연산을 수행해야 하는 경우 사용할 수 있다.
//         *
//         * with()
//         */
////        urlInfo = postRequest.urlInfo?.let { postConverter.convert(it) }
//        val person = Person("name", 30, true)
//        Person("김문수", 34, false).name?.let { println(it) }
//        person.name?.let { println(it) } //name
//        person.name?.let { addGood(it) }.let { println(it) } //name is good
//        person.name?.run { }.let { println(it) } //kotlin.Unit
//
//        var name: String = "널아님";
//        val copy : String = name!!;
//        println("copy : $copy")
//
//    }
//
//    @Test
//    fun elvis_test() {
//        /**
//         * 엘비스 연산자는 널값을 허용하지 않는 변수에 널 값이 들어 갔을 때 널 값을 변환할 수 있는 함수의
//         * 결과를 만들어 줍니다.
//         * null대신 사용할 디폴트 값을 지정할 때 편리하게 사용할 수 있는 연산자.(엘비스연산자 -> ?:)
//         * ?: 를 사용하면 null일 때 디폴트 값을 지정할 수 있다.
//         * ex)
//         *   fun strLenSafe(s: String?): Int = s?.length ?: 0
//         *   fun test(s: String?) : String = s ?: ""
//         *
//         */
//        var yts: String? = null
//
//        val name: String = yts ?: "YTS"
//        println("name : $name")
//        val name2 = yts ?: return
//        val name3 = yts ?: throw RuntimeException("gg")
//        println(yts)
//    }
//    @Test
//    fun filter_not_test() {
//        //filter, filterNot test
//        println("filter/filterNot test start ")
//        val numbers: List<Int> = listOf(1,2,3,4,5,6,7)
//        val evenNumbers = numbers.filter { it % 2 == 0 }
//        val notMultiplesOf3 = numbers.filterNot { it % 3 == 0 }
//        println(evenNumbers)
//        println(notMultiplesOf3)
//    }
//    @Test
//    fun null_safe_test() {
//        /**
//         * 안전한 호출 연산자 ?.
//         * 안전호출연산자를 연속으로 사용하여 데이터에 대한 null체크를 연속으로 할수도 있다.
//         * fun getCountryName() : String {
//         *   val country = company?.address?.country
//         *   return if (country != null) country else "unKnown"
//         * }
//         */
//        //자바에서 의 널 체크
//        println("### 안전한호출 연산자 ?. 테스트 ###")
//        val s : String? = "im string";
//        val result : String? = s?.toUpperCase()
//        println("result : $result")
//        println("length: ${strLen(s?.toString())}")
//
////        val result2 : String = null
//    }
//
//    private fun strLen(s: String?) : Int? = s?.length
//
//    private fun addGood(param: String): String {
//        return param + " is good"
//    }
//    //statement
//    private fun max1(a: Int, b: Int): Int {
//
//        return if (a > b) a else b //statement
//    }
//    //expression
//    private fun max2(a: Int, b: Int): Int = if (a > b) a else b
//    //식이 본문인 함수는 굳이 반환타입을 적지 않아도 컴파일러가 본문식을 분석해서 식의 결과타입을 함수반환
//    //타입으로 정해준다.
//    private fun max3(a: Int, b: Int) = if (a > b) a else b
//
//}