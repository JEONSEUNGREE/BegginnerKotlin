package kr.tutorial.myfirstapp

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                Surface {
                    UnitConverter()
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
fun UnitConverter() {

    Column (
        // 컬럼이 전체 영역 차지
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Unit Converter", modifier = Modifier.padding(16.dp))
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = "", onValueChange = {})
        Row {
            // 드롭다운 메뉴는 위치를 잡아주는 부모가 필요하기에 Box로 각 드롭다운버튼을 감싸준다
            Box {
                // 버튼 클릭시 토스트 팝업으로 Thanks for clicking이 뜬다.
                Button(onClick = {}) {
                    // 버튼 메시지
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                }
                DropdownMenu(expanded = false, onDismissRequest = {}) {
                    DropdownMenuItem(
                        text = { Text("Centimeters")},
                        onClick = {}
                    )
                    DropdownMenuItem(
                        text = { Text("Meters")},
                        onClick = {}
                    )
                    DropdownMenuItem(
                        text = { Text("Feet")},
                        onClick = {}
                    )
                    DropdownMenuItem(
                        text = { Text("Millimeters")},
                        onClick = {}
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                // 버튼 클릭시 토스트 팝업으로 Thanks for clicking이 뜬다.
                Button(onClick = {}) {
                    // 버튼 메시지
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                }
                DropdownMenu(expanded = false, onDismissRequest = {}) {
                    DropdownMenuItem(
                        text = { Text("Centimeters")},
                        onClick = {}
                    )
                    DropdownMenuItem(
                        text = { Text("Meters")},
                        onClick = {}
                    )
                    DropdownMenuItem(
                        text = { Text("Feet")},
                        onClick = {}
                    )
                    DropdownMenuItem(
                        text = { Text("Millimeters")},
                        onClick = {}
                    )
                }
            }
        }
        Text("Result : ")
    }
}

// 버튼, 토스트 관련 설명
//@Composable
//fun UnitConverter() {
//
//    Column {
//
//        Text("Unit Converter")
//        OutlinedTextField(value = "", onValueChange = {})
//        Row {
//            // LoaclContext 안드로이드 액티비티(화면)를 가져온다.
//            val context = LocalContext.current
//
//            // 버튼 클릭시 토스트 팝업으로 Thanks for clicking이 뜬다.
//            Button(onClick = {
//                Toast.makeText(context,
//                    "Thanks for clicking!",
//                    Toast.LENGTH_LONG).show()
//            }) {
//                // 버튼 메시지
//                Text("Click Me")
//            }
//
//        }
//        Text("Result : ")
//    }
//}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}

// AVD(Android Virtual Device) 가상시뮬까지 구동시킬 필요없이 코드를 프리뷰로 볼수있는 기능
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyFirstAppTheme {
//        Greeting("HAHA")
//    }
//}