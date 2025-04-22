package kr.tutorial.myfirstapp.basic.section7

import androidx.compose.ui.text.toUpperCase


fun main() {

    // null인경우 기본값설정
    var name: String? = "Default"

    println(name)

    // name이 null이 아닌경우 실행
    name?.let {
        name = it.toUpperCase()
    }

    println(name)
}