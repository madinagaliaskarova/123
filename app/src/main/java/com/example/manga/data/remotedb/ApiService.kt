package com.example.manga.data.remotedb

import com.example.manga.data.model.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("v1/manga/")
    suspend fun listManga(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<MangaModelPage>

    @GET("v1/manga/1/comments/")
    suspend fun listMangaDetailed() : Response<MangaDetailedModel>

    @POST("auth/signup/")
    suspend fun signUp(@Body string: SignUpModel) : Response<SignUpResponse>

    @POST("auth/signin/")
    suspend fun signIn(@Body loginRequest: SignInModel): Response<SignUpModel>

    @GET("v1/manga/")
    suspend fun getAllMangaSearch(
        @Query("search") search: String
    ):Response<MangaModel>


    @GET("v1/manga/{id}/")
    suspend fun idManga(
@Path("id") id:Int
    ): Response<MangaDetailedModel>


    @Multipart
    @POST("auth/signup/") // здесь вставь свой путь
    fun signUp(
        @Part("username") username: RequestBody,
        @Part("nickname") nickname: RequestBody,
        @Part image_file: MultipartBody.Part,
        @Part("password") password: RequestBody
    ): Call<SignUpResponse> // здесь у тебя ответ SignUpResponse или как

}








