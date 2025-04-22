//package kr.tutorial.myfirstapp.basic.section8
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.Button
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.sp
//import kr.tutorial.myfirstapp.ui.theme.MyFirstAppTheme
//
//// MVVM 모델 사용전 코드
//// Model 데이터와 로직 처리
//// View 사용자에게 보여지는 UI
//// ViewModel 모델과 뷰 사이에 중간다리
///*
//1. 사용자가 View(UI)에서 어떤 액션을 함 (버튼 클릭 등)
//
//2. View가 ViewModel에 요청을 보냄
//
//3. ViewModel이 Model을 호출해서 데이터 처리
//
//4. Model이 결과를 ViewModel에 전달
//
//5. ViewModel은 데이터를 가공해서 View에 전달
//
//6. View는 그 데이터를 UI에 보여줌
//
//*/
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            MyFirstAppTheme {
//                // modifier는 코틀린타입중 하나
//                Surface {
//                    CounterApp()
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun CounterApp() {
//
//    val count = remember { mutableStateOf(0) }
//
//    fun increment() = count.value++
//
//    fun decrement() = count.value--
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = "Count: ${count.value}",
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold
//        )
//        Row {
//            Button(onClick = {
//                increment()
//            }) {
//                Text("Increment")
//            }
//
//            Button(onClick = {
//                decrement()
//            }) {
//                Text("Decrement")
//            }
//        }
//    }
//
//}