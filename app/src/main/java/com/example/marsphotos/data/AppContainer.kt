package com.example.marsphotos.data

import MarsApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import okhttp3.MediaType.Companion.toMediaType

//애플리케이션 컨테이너 만들기
interface AppContainer {
    val marsPhotosRepository:MarsPhotosRepository
}

class DefaultAppContainer() : AppContainer {

    private val BASE_URL =
        "https://android-kotlin-fun-mars-server.appspot.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
    //속성 재정의
    override val marsPhotosRepository: MarsPhotosRepository by lazy {
        DefaultMarsPhotosRepository(retrofitService)
    }


}