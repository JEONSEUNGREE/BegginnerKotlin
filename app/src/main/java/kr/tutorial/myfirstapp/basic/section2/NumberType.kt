package kr.tutorial.myfirstapp.basic.section2


// 코틀린의 숫자 타입은 Integer, Shorts, Float, Double, Long이 존재한다.
// 숫자 변수 선언시 타입지정을 하지않고 var또는val로 선언시 숫자 크기에 맞게 조정한다.
// val test = 1; 의 경우 int형으로 저장하며
// int로 저장할수없는 30억정도의 숫자인경우 자동으로 Long형태로 변한된다.
// 숫자 타입을 명시하고 싶다면 지정하면 된다.
fun main() {
    // val은 변경 불가 , var는 변경 가능
    var number = 1
    number = 2
    println(number::class) // int

    // var로 숫자 1을 변수로 선언후 30억으로 초기화하면 에러가 발생한다
    // 이미 초기에 int로 생성되었기 때문이다.
    // 위에 변수인 number를 number = 30000000000 수정하면 에러가 발생한다는 의미
    // 30억을 선언하려면 애초에 Long타입으로 생성하거나 맨처음부터 30억으로 초기화하면된다
    var number2 : Long = 1
    println(number2::class)

    // Unsinged Integer type이라는게 존재하는데
    // UByte는 2^8인 -128 ~ 128 까지 범위를 의미하는데
    // 양수로만 2^8 0 ~ 255까지 범위를 의미한다.
    // UShorts 0 ~ 65535
    // UInt 0 ~ 2^32 - 1
    // ULong 0 ~ 2^64 - 1
}