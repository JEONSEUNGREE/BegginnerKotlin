package kr.tutorial.myfirstapp.basic.section8

// 다중 인터페이스 구현은 가능, 클래스 상속은 한개만 가능
class SecondClass : FirstClass(), FirstInterFace {

    override fun generic(blood: String) {
        // 부모 생성자의 정확한 지정 필요
        super<FirstClass>.generic("JAPAN")
    }

    override fun role() {
        super<FirstInterFace>.role()
        super<FirstClass>.role()
    }

    override fun generic() {
        // 메서드명이 겹치는경우 개발자가 직접 선택해서 호출 둘다 선택가능하고 하나만 선택가능
        super<FirstInterFace>.generic()
        super<FirstClass>.generic()
    }

}

interface FirstInterFace {

    fun generic() {
        println("Duplicated Method Name")
    }

    fun role(){
        println("Interface")
    }
}

fun main() {
    var parentClass = FirstClass()
    var childClass = SecondClass()

    parentClass.generic("KOREAN")
    childClass.generic("ENGLISH")

    childClass.generic()
    childClass.age()
    childClass.role()
}