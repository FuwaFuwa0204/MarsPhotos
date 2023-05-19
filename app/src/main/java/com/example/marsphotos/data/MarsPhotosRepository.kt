package com.example.marsphotos.data

import MarsApiService
import com.example.marsphotos.network.MarsPhoto


interface MarsPhotosRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

class DefaultMarsPhotosRepository(
    private val marsApiService: MarsApiService
) : MarsPhotosRepository{
    override suspend fun getMarsPhotos(): List<MarsPhoto> = marsApiService.getPhotos()
}
