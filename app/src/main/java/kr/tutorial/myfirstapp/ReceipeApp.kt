package kr.tutorial.myfirstapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kr.tutorial.myfirstapp.basic.section10.CategoryDetailScreen
import kr.tutorial.myfirstapp.basic.section9.Category
import kr.tutorial.myfirstapp.basic.section9.MainViewModel
import kr.tutorial.myfirstapp.basic.section9.RecipeScreen

@Composable
fun RecipeApp(navController: NavHostController) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewstate by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route){

        composable(route = Screen.RecipeScreen.route) {
            RecipeScreen(viewstate = viewstate, navigateToDetail = {
                // 현재 화면에서 데이터를 저장해서 네비게이션이동하며 해당 페이지에서 .get("cat")으로 사용가능
                // RecipeScreen에서 navigateToDetail 호출시 가져오는 데이터
                // 직렬화
                navController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
                navController.navigate(Screen.DetailScreen.route)
            })
        }
        composable (route = Screen.DetailScreen.route){
            // 역직렬화
            val category =
                navController.previousBackStackEntry?.savedStateHandle?.
                get<Category>("cat") ?: Category("", "", "", "")

            CategoryDetailScreen(category = category, navigateToRecipe = {
                navController.navigate(Screen.RecipeScreen.route)
            })

        }
    }

}