package kr.tutorial.myfirstapp.basic.section8

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    // private는 _ prefix 관습
    private val _count = mutableStateOf(0)

    // 외부 접근
    val count: MutableState<Int> = _count

    fun increment() {
        _count.value++
    }

    fun decrement() {
        _count.value--
    }


}