package kr.tutorial.myfirstapp.basic.section9

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// viewModel을 통해서 recipeService를 따로 import하지않아도 잡힘
class MainViewModel : ViewModel() {

    private val _categorieState = mutableStateOf(RecipeState())

    val categoriesState : State<RecipeState> = _categorieState

    init{
        // 이 클래스가 생성됨과 동시에 아래 코루틴 함수 실행 (비동기)
        fetchCategories()
    }

    private fun fetchCategories() {
        // 비동기로 호출했던 카테고리 호출함수를 호출할때 코루틴함수인 launch로 호출
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()

                _categorieState.value = _categorieState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                _categorieState.value = _categorieState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }

    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null

    )


}