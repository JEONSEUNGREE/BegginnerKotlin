package kr.tutorial.myfirstapp.basic.section9

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)

data class CatogoriesResponse(
    val categories: List<Category>
)