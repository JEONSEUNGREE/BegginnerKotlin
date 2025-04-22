package kr.tutorial.myfirstapp.basic.section8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kr.tutorial.myfirstapp.basic.section8.CounterViewModel
import kr.tutorial.myfirstapp.ui.theme.MyFirstAppTheme

// MVVM 모델 사용 코드

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // 뷰모델관련 의존성 빌드스크립트에 추가 필요
            // 직접 new 하지않는이유는 안드로이드에 직접관리하는 뷰모델을 가져오기 위함
            // 스프링에 IOC등록후 DI하는것과 같다고 볼수있음
            // Hilt사용시도 마찬가지 개념
            val viewModel : CounterViewModel = viewModel()
            MyFirstAppTheme {
                // modifier는 코틀린타입중 하나
                Surface {
                    CounterApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun CounterApp(viewModel: CounterViewModel) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Count: ${viewModel.count.value}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Row {
            Button(onClick = {
                viewModel.increment()
            }) {
                Text("Increment")
            }

            Button(onClick = {
                viewModel.decrement()
            }) {
                Text("Decrement")
            }
        }
    }

}