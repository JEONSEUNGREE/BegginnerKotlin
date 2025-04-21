package kr.tutorial.myfirstapp.basic.section6

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.tutorial.myfirstapp.ui.theme.MyFirstAppTheme
import kotlin.random.Random

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
                Surface {
                    CaptainGame()
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

@Composable
fun CaptainGame() {
    var treasureFound = remember { mutableStateOf(0) }
    var direction = remember { mutableStateOf("North") }
//    var stateBy by remember { mutableStateOf("North") } by로 선언하는 경우 값에 바로 접근하여 변수명.value 를 생략하고 변수명만 선언하여 사용가능하다.
//    Text(text = "Treasure Found : ${stateBy}")

    Column {
        Text(text = "Treasure Found : ${treasureFound.value}")
        Text(text = "Treasure Found : ${direction.value}")

        Button(onClick = {
            if (Random.nextBoolean()) {
                treasureFound.value += 1
                direction.value = "West"
            }
        }){
            Text("Sail West")
        }
        Button(onClick = {
            if (Random.nextBoolean()) {
                treasureFound.value += 1
                direction.value = "East"
            }
        }){
            Text("Sail East")
        }
        Button(onClick = {
            if (Random.nextBoolean()) {
                treasureFound.value += 1
                direction.value = "North"
            }
        }){
            Text("Sail North")
        }
        Button(onClick = {
            if (Random.nextBoolean()) {
                treasureFound.value += 1
                direction.value = "South"
            }
        }){
            Text("Sail South")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    CaptainGame()
}
