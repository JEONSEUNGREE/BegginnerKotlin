package kr.tutorial.myfirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kr.tutorial.myfirstapp.ui.theme.MyFirstAppTheme

// 액티비티란 모바일기기의 화면을 의미하며 화면간의 이동을 액티비티에서 하나의 액티비티로 이동한다고 말한다.
// 아래 MainActivity뒤에 하나의 클래스가 붙는데 메인 액티비티를 ComponentActivity로 동작시킨다는 의미이다.
// Java의 extends ComponentActivity라고 볼수있다. new Instance는 아닐수밖에 없는게 오바라이드와 상속자의 생성자 호출인 super가 존재하기때문이다.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstAppTheme {
                // modifier는 코틀린타입중 하나
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

// AVD(Android Virtual Device) 가상시뮬까지 구동시킬 필요없이 코드를 프리뷰로 볼수있는 기능
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstAppTheme {
        Greeting("HAHA")
    }
}