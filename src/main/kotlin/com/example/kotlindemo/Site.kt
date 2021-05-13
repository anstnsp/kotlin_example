package com.example.kotlindemo

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * 데이터클래스는 클래스 앞에 data를 붙여준다.
 * 데이터클래스는 toString(), equals(), hashCode(), copy() 메서드를 자동으로 만들어준다.
 * copy() 메소드는 얕은복사임. 인자로 생성자에 정의된 프로퍼티 넘길 수 있으며 해당 값만 변경되어 카피댐.
 * 클래스에서 위의 메서드를 오버라이드하면 그 함수는 직접 구현된 코드를 사용한다.
 * 데이터클래스는 상속 받을 수 없다.
 *@field:NotBlank(message = "이름은 필수입니다.")
@field:Min(value = 2, message = "이름은 2자 이상입니다.")
val name: String?,
 */


class Site() {
    //    @field:NotBlank("ruldms 필수입니다.")
    @NotBlank(message = "무야호오오")
    lateinit var url: String

    //    @field:NotBlank("제목은필수")
    @NotBlank
    lateinit var title: String
}

class Man(

    val asdf: String,

    val lll: String ,
)


class Amon(

    val good: String
)