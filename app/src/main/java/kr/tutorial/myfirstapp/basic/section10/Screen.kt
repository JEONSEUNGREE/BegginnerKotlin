package kr.tutorial.myfirstapp.basic.section10

// sealed란 서브 클래스의 자료형중 하나로 상속가능클래스 계층을 제한한다.
/* 예제
sealed class Result

data class Success(val data: String) : Result()
data class Error(val exception: Exception) : Result()
object Loading : Result()

 */
sealed class Screen(val route: String) {
    object RecipeScreen: Screen("recipescreen")
    object DetailScreen: Screen("detailscreen")
}