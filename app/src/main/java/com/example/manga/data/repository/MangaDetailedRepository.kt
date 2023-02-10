package com.example.manga.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.manga.data.common.Resource
import com.example.manga.data.model.MangaDetailedModel
import com.example.manga.data.remotedb.ApiService
import kotlinx.coroutines.Dispatchers

open class MangaDetailedRepository(private val apiService: ApiService) {

    fun detailedMangaPage(): LiveData<Resource<MangaDetailedModel>> {
        return detailedManga()
    }

    fun detailedManga(): LiveData<Resource<MangaDetailedModel>> {
        return liveData(Dispatchers.IO) {
            val response =
                apiService.listMangaDetailed()
            emit(
                if (response.isSuccessful) Resource.success(response.body()) else Resource.error(
                    response.message(), response.body(), response.code()
                )
            )
        }
    }
}