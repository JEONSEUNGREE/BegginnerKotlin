package kr.tutorial.myfirstapp.basic.section10

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import kr.tutorial.myfirstapp.basic.section9.Category


@Composable
fun CategoryDetailScreen(category: Category, navigateToRecipe: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = category.strCategory,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Image(
            //rememberAsyncImagePainter이 코드는 의존성에 추가한 라이브러리
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = "${category.strCategory} Thumbnail",
            // 가로 세로 이미지 비율 1:1
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )

        Text(
            text = category.strCategoryDescription,
            textAlign = TextAlign.Justify,
            // 화면전체가 아 현재 텍스트만 스크롤한다.rememberScrollState
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )

        Button(onClick = {
            navigateToRecipe()
        }) {
            Text("Go To Recipe Page")
        }
    }
}