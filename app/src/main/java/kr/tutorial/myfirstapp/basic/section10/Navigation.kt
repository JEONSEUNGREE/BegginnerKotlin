package kr.tutorial.myfirstapp.basic.section10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.tutorial.myfirstapp.basic.section10.FirstScreen
import kr.tutorial.myfirstapp.basic.section10.SecondScreen
import kr.tutorial.myfirstapp.basic.section9.RecipeScreen
import kr.tutorial.myfirstapp.ui.theme.MyFirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstAppTheme {
                Surface {
                    MyApp()
                }
            }
        }
    }
}

@Composable
// 백스택을 사용해 화면간에 이동하는데 이동할때마다 기존화면이 쌓이게된다.
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "firstscreen") {
        composable("firstscreen"){
            FirstScreen {name ->
                // 버튼에 이동할수있도록 함수를 넘김
                navController.navigate("secondscreen/$name")
            }
        }
        composable(route = "secondscreen/{name}") {
            val name = it.arguments?.getString("name") ?: "no name"
            SecondScreen(name) {
                navController.navigate("firstscreen")
            }
        }
    }
}
