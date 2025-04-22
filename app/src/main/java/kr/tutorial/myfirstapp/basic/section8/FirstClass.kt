package kr.tutorial.myfirstapp.basic.section8

// 상속을 위해서는 open이라는 접근 가능 선언이 필요
open class FirstClass {

    // 오버라이드도 open 필요
    open fun generic(blood : String) {
        println(blood)
    }

    open fun generic() {
        println("BONE TO BE")
    }

    fun age() {
        println(0)
    }

    open fun role(){
        println("Class")
    }
}