package kr.tutorial.myfirstapp.basic.section9

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

// 아래 인터페이스를 만들어두고 인터페이스 내부의 엔드포인트를 따라서 함수를 호출하면 사용가능
val recipeService = retrofit.create(ApiService::class.java)

interface ApiService {

    // http 요청
    @GET("categories.php")
    // suspend 함수는 비동기 함수를 의미한다.
    // 코루틴에서만 사용가능하다.
    // 코루틴은 코틀린의 대표적인 비동기 처리방식이자 스레드보다 가벼운 동시성 프로그래밍
    /*
    기존 비동기 방식
    fun getUser(callback: (User) -> Unit) {
        Thread {
            Thread.sleep(1000)
            callback(User("홍길동"))
        }.start()
    }

    코루틴 사용 방식
    suspend fun getUser(): User {
        delay(1000)  // 1초 대기, but 스레드 안 막힘!
        return User("홍길동")
    }

    */
    suspend fun getCategories(): CatogoriesResponse
}