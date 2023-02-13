package com.example.manga.data.remotedb

import com.example.manga.data.model.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("v1/manga/")
    suspend fun listManga(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<MangaModelPage>

//    @GET("v1/manga/1/comments/")
//    suspend fun listMangaDetailed(): Response<MangaDetailedModel>


    @GET("v1/manga/")
    suspend fun getAllMangaSearch(
        @Query("search") search: String
    ): Response<MangaModel>


    @GET("v1/manga/{id}/")
    suspend fun idManga(
        @Path("id") id: Int
    ): Response<MangaDetailedModel>


}








