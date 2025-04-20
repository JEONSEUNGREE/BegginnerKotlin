package kr.tutorial.myfirstapp.basic.section4

fun main(){

    // 불변 리스트
    val immutableList = listOf("Processor", "Ram", "Graphic Card")

    println(immutableList::class)

    // 가변 리스트
    // val로 선언하게 값을 바꿀수있는 이유는 val은 참조위치만 바꿀수없고
    // 선언된 객체 내부의 값은 바꿀수있기 때문이다.
//    val mutableListOf : MutableCollection<String> = mutableListOf("Processor", "Ram", "Graphic Card")

    val mutableListOf = mutableListOf("Processor", "Ram", "Graphic Card")
    mutableListOf.remove("Ram")
    mutableListOf.add("SSD")
    mutableListOf.add(1,"Main Board")

//    for(index in 0 until mutableListOf.size)
//    for (item in mutableListOf) {
//        println(item)
//    }

    mutableListOf.stream().map { println(it) }

    println(mutableListOf::class) // ArrayList

}