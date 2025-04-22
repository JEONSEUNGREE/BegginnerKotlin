//package kr.tutorial.myfirstapp.basic.section6
//
//import android.os.Bundle
//import android.widget.Toast
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowDropDown
//import androidx.compose.material3.Button
//import androidx.compose.material3.DropdownMenu
//import androidx.compose.material3.DropdownMenuItem
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import kr.tutorial.myfirstapp.ui.theme.MyFirstAppTheme
//
//// 액티비티란 모바일기기의 화면을 의미하며 화면간의 이동을 액티비티에서 하나의 액티비티로 이동한다고 말한다.
//// 아래 MainActivity뒤에 하나의 클래스가 붙는데 메인 액티비티를 ComponentActivity로 동작시킨다는 의미이다.
//// Java의 extends ComponentActivity라고 볼수있다. new Instance는 아닐수밖에 없는게 오바라이드와 상속자의 생성자 호출인 super가 존재하기때문이다.
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            MyFirstAppTheme {
//                // modifier는 코틀린타입중 하나
//                Surface {
//                    UnitConverter()
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Composable
//fun UnitConverter() {
//
//    var inputValue by remember{ mutableStateOf("") }
//    var outputValue by remember{ mutableStateOf("") }
//    var inputUnit by remember{ mutableStateOf("") }
//    var outputUnit by remember{ mutableStateOf("") }
//    var iExpanded by remember{ mutableStateOf(false) }
//    var oExpanded by remember{ mutableStateOf(false) }
//
//    Column (
//        // 컬럼이 전체 영역 차지
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ){
//        Text("Unit Converter", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.headlineLarge)
//        Spacer(modifier = Modifier.height(8.dp))
//
//        OutlinedTextField(value = inputValue,onValueChange = {
//            inputValue = it
//        })
//        Row {
//            // 드롭다운 메뉴는 위치를 잡아주는 부모가 필요하기에 Box로 각 드롭다운버튼을 감싸준다
//            Box {
//                // 버튼 클릭시 토스트 팝업으로 Thanks for clicking이 뜬다.
//                Button(onClick = {
//                    iExpanded = !iExpanded
//                }) {
//                    // 버튼 메시지
//                    Text("Select")
//                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
//                }
//                DropdownMenu(expanded = iExpanded, onDismissRequest = {
//                    iExpanded = !iExpanded
//                }) {
//                    DropdownMenuItem(
//                        text = { Text("Centimeters")},
//                        onClick = {
//                            inputUnit = "Centimeters"
//                            iExpanded = !iExpanded
//                        }
//                    )
//                    DropdownMenuItem(
//                        text = { Text("Meters")},
//                        onClick = {
//                            inputUnit = "Meters"
//                            iExpanded = !iExpanded
//                        }
//                    )
//                    DropdownMenuItem(
//                        text = { Text("Feet")},
//                        onClick = {
//                            inputUnit = "Feet"
//                            iExpanded = !iExpanded
//                        }
//                    )
//                    DropdownMenuItem(
//                        text = { Text("Millimeters")},
//                        onClick = {
//                            inputUnit = "Millimeters"
//                            iExpanded = !iExpanded
//                        }
//                    )
//                }
//            }
//            Spacer(modifier = Modifier.width(16.dp))
//            Box {
//                // 버튼 클릭시 토스트 팝업으로 Thanks for clicking이 뜬다.
//                Button(onClick = {
//                    oExpanded = !oExpanded
//                }) {
//                    // 버튼 메시지
//                    Text("Select")
//                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
//                }
//                DropdownMenu(expanded = oExpanded, onDismissRequest = {
//                    oExpanded = !oExpanded
//                }) {
//                    DropdownMenuItem(
//                        text = { Text("Centimeters")},
//                        onClick = {
//                            outputUnit = "Centimeters"
//                            oExpanded = !oExpanded
//                        }
//                    )
//                    DropdownMenuItem(
//                        text = { Text("Meters")},
//                        onClick = {
//                            outputUnit = "Meters"
//                            oExpanded = !oExpanded
//                        }
//                    )
//                    DropdownMenuItem(
//                        text = { Text("Feet")},
//                        onClick = {
//                            outputUnit = "Feet"
//                            oExpanded = !oExpanded
//                        }
//                    )
//                    DropdownMenuItem(
//                        text = { Text("Millimeters")},
//                        onClick = {
//                            outputUnit = "Millimeters"
//                            oExpanded = !oExpanded
//                        }
//                    )
//                }
//            }
//        }
//        Text("inputUnit : ${inputUnit}")
//        Text("outputUnit : ${outputUnit}")
//        Text("Result : ${inputValue + " " + outputUnit}")
//    }
//}
//
//
//@Preview(showBackground = true)
//@Composable
//fun UnitConverterPreview() {
//    UnitConverter()
//}
