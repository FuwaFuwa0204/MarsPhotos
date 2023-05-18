package com.example.marsphotos.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"
//객체 빌드
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
    .baseUrl(BASE_URL)
    .build()

//Retrofit이 HTTP 요청을 사용하여 웹 서버와 통신하는 방법을 정의
interface MarsApiService {
    //엔드포인트 /photos
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}
//Retrofit 공개 객체 정의 -> 서비스 초기화
object MarsApi {
    //늦은 초기화 by lazy => by lazy로 정의한 내용은 늦게 초기화하고 프로퍼티 사용시 초기화한다.
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}










