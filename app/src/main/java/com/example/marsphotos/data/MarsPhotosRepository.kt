package com.example.marsphotos.data

import MarsApiService
import com.example.marsphotos.network.MarsPhoto


interface MarsPhotosRepository {
    //추상 함수
    suspend fun getMarsPhotos(): List<MarsPhoto>
}
//인터페이스를 구체화
class DefaultMarsPhotosRepository(
    private val marsApiService: MarsApiService
) : MarsPhotosRepository{
    override suspend fun getMarsPhotos(): List<MarsPhoto> = marsApiService.getPhotos()
}
