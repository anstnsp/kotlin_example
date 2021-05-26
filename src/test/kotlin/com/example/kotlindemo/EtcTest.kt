package com.example.kotlindemo

import org.junit.jupiter.api.Test

class EtcTest {

    @Test
    fun associate_groupby테스트() {
        data class Person(val name: String, val city: String, val phone: String)
        val people = listOf(
            Person("문수", "서울", "02-888-123456"),
            Person("혜선", "광주", "02-777-789123"),
            Person("미리", "전주", "02-999-456789"),
            Person("민수", "전주", "02-999-123456"))

        /**
         * associate는 List를 Map으로 만들어줍니다.
         * ex) list.associate { key to value }
         * 반환된 Map은 원래 컬렉션 요소의 순서를 유지합니다.
         */
        val phoneBook1 = people.associate { it.name to it}
        println("phoneBook1 ->> $phoneBook1")
        //결과 : phoneBook1 ->> {문수=Person(name=문수, city=서울, phone=02-888-123456), 혜선=Person(name=혜선, city=광주, phone=02-777-789123), 미리=Person(name=미리, city=전주, phone=02-999-456789), 민수=Person(name=민수, city=전주, phone=02-999-123456)}

        /**
         * associateBy는 list를 map으로 만들어줍니다.키와 값을만들때 람다를 인자로 받습니다.
         * 키(Key)는 KeySelector 파라미터에서 정의됩니다. 뿐만 아니라 옵션으로 valueSelector 를 정의할 수 있습니다.
         * (default는 해당원소가 value가 됩니다.)
         * 또한, 중복된 값(Value)이 있다면 마지막에 있는 원소가 값이 됩니다.
         * 반환된 Map은 원래 컬렉션 요소의 순서를 유지합니다.
         */
        val phoneBook2 = people.associateBy { it.name }
        println("phoneBook2 ->> $phoneBook2")
        //결과 : phoneBook2 ->> {문수=Person(name=문수, city=서울, phone=02-888-123456), 혜선=Person(name=혜선, city=광주, phone=02-777-789123), 미리=Person(name=미리, city=전주, phone=02-999-456789), 민수=Person(name=민수, city=전주, phone=02-999-123456)}

        val cityBook = people.associateBy({it.phone}, {it.city})
        println("cityBook =>> $cityBook")
        println("cityBook =>> $cityBook")
        println("cityBook =>> $cityBook")

        println("cityBook =>> $cityBook")
        //결과 : cityBook =>> {02-888-123456=서울, 02-777-789123=광주, 02-999-456789=전주, 02-999-123456=전주}

        val peopleCity = people.associateBy({ it.city }, { it.name })
        println("peoplecity =>> $peopleCity")
        //결과 : peoplecity =>> {서울=문수, 광주=혜선, 전주=민수}

        /**
         * groupBy는 associateBy와 비슷하지만 value를 List로 만들어 줍니다.
         * 반환된 Map은 원래 컬렉션 요소의 순서를 유지합니다.
         */
        val peopleCities = people.groupBy({ it.city }, { it.name })
        println("peopleCities ->> $peopleCities")
        //결과 : peopleCities ->> {서울=[문수], 광주=[혜선], 전주=[미리, 민수]}

        val numbers1 = listOf(1, -2, 3, -4, 5, -6)
        val evenOdd = numbers1.partition { it % 2 == 0 }
        val (positives, negatives) = numbers1.partition { it > 0 }
        //evenOdd = ([-2, -4, -6], [1, 3, 5])
        // positives = [1, 3, 5]
        // negatives = [-2, -4, -6]

        val numbers2 = listOf(1, 2, 3) // 1
        val tripled = numbers2.flatMap { listOf(it, it, it) } // 2
        // [1, 1, 1, 2, 2, 2, 3, 3, 3]


        val A = listOf("a", "b", "c") // 1
        val B = listOf(1, 2, 3, 4) // 1
        val resultPairs = A zip B // 2 [(a,1), (b,2), (c,3)]
        val resultReduce = A.zip(B) { a, b -> "$a$b" } // 3 [a1, b2, c3]

        val list = listOf(0, 10, 20)
        println(list.getOrElse(1) { 42 }) // 1
        println(list.getOrElse(10) { 42 })

        val map = mutableMapOf<String, Int?>()
        println(map.getOrElse("x") { 1 }) // 1
        map["x"] = 3
        println(map.getOrElse("x") { 1 }) // 2
        map["x"] = null
        println(map.getOrElse("x") { 1 }) // 3

    }

}



