package kr.tutorial.myfirstapp.basic.section9

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// 네비게이션에서 다른 화면으로 데이터를 전달하기위해 직렬화를 위한 어노테이션
// 옮겨진화면에서는 다시 코틀린객체로만드는 역직렬화 작업을한다.
@Parcelize
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
): Parcelable


data class CatogoriesResponse(
    val categories: List<Category>
)