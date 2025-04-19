package kr.tutorial.myfirstapp.basic.section3

fun main() {
    println(Number().add(1,2))
    println(Number().divide(1,3))
    // 일반 클래스 자바와 비교
    println(NotJava())
    // 데이터 클래스
    println(CoffeeDetails("Sweet",1) == CoffeeDetails("Sweet",1)) // true로 나옴 주소비교가 아닌 값비교
    // 데이터클래스는 DTO, VO등을 빠르게 구현할때 주로 사용되며 클래스 내부에 연산등이 필요한 경우는 일반클래스 사용을 한다.
    // 또한 하나의 var이상이 선언되어야 사용가능
    // 자바에서의 record타입과 유사하다
}

// 코틀린의 클래스는 자바 클래스처럼 생성자를 갖는다.
// 또한 자바처럼 한파일에 한클래만 허용하는게 아닌 다중으로 클래스 설정 가능함
// 코틀린 생성자는 클래스명옆에 소괄호로된 인수자리를 말한다.
// init이란 함수는 생성자 호출 후 호출된다.
// 보조생성자로 constructor가 존재한다.
class Number() {
    // 함수의 마지막에 : Int는 리턴값의 형을 의미한다.
    // 함수에 리턴값 형태가 없는경우 void이라고 생각하면된다.
    fun add(num1 : Int, num2: Int) : Int {
        // 또한 자바처럼 new를 선언하지 않아도 클래스를 호출하면 생성되고 각기 다른 객체이다.
        // System.identityHashCode(object)를 통해 확인가
        // 선언하지 않고 사용시도 마찬가지로 익명객체처럼 하나의 새로운 주소와 객체 취급을한다.
        var addressTest : Number = Number()
        var addressTest2 : Number = Number()
        println(addressTest)
        println(addressTest2)
        println(Number::class)
        return num1 + num2
    }
    // 나누기시 체인메서드로 더블타입 지정가능
    fun divide(num1 : Int, num2: Int) : Double{
        return num1/num2.toDouble()
    }
}

// 클래스 생성자 호출 -> contructor존재시 해당 함수에 this호출 (단 함수 내부는 호출X) -> init함수 호출 -> contructor함수 내부 호출)
class NotJava(
    var realConstructor: Int,
    var realConstructor2: Int,
    var realConstructor3: String
){
    // 생성자는 아니고 초기화 블록 생성자는 클래스옆 인수형태 소괄호
    // 생성자 -> init -> constructor순서로 호출
    init {
        println(realConstructor2)
        println("order ${realConstructor + 1}")
    }
    // 보조 생성자는 꼭 주 생성자를 호출해줘야한다.
    constructor() : this(0,2,"StringType"){
        println("order ${realConstructor + 2}")
    }
}

//
data class CoffeeDetails(var flavor: String, var sugar: Int)


