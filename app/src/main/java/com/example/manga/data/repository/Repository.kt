package com.example.manga.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.manga.data.common.EverythingNewsPageSource
import com.example.manga.data.common.Resource
import com.example.manga.data.model.MangaDetailedModel
import com.example.manga.data.model.MangaModel
import com.example.manga.data.model.MangaModelPage
import com.example.manga.data.remotedb.ApiService
import kotlinx.coroutines.Dispatchers


open class Repository
    (
    private val apiService: ApiService,
    val everythingNewsPageSource: EverythingNewsPageSource
) {


    fun listMangaPaging(query: String): Pager<Int, MangaModel> {
        return Pager(PagingConfig(pageSize = 10)) {
            EverythingNewsPageSource(apiService, query)
        }
    }

    fun listManga(): LiveData<Resource<MangaModelPage>> {
        return liveData(Dispatchers.IO) {
            val response =
                apiService.listManga(10, 0)
            emit(
                if (response.isSuccessful) Resource.success(response.body()) else Resource.error(
                    response.message(), response.body(), response.code()
                )
            )
        }
    }



    fun SearchManga(search: String): LiveData<Resource<MangaModel>> {
        return liveData(Dispatchers.IO) {
            val response =
                apiService.getAllMangaSearch(search)
            emit(
                if (response.isSuccessful) Resource.success(response.body()) else Resource.error(
                    response.message(), response.body(), response.code()
                )
            )
        }
    }

//    fun manga1(): Flow<PagingData<MangaModel>> = flow<PagingData<MangaModel>> {
//        everythingNewsPageSource.load()
//    }
//
//        Pager(PagingConfig(pageSize = 5)) {
//        everythingNewsPageSource.create(android)
//    }.flow.stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())

}


//    fun createNewUser(user : SignUpModel): MutableLiveData<SignUpResponse> {
//        lateinit var createNewUserLiveData: MutableLiveData<SignUpResponse>
//
//        val retrofitService = apiService
//        val username = RequestBody.create("madina12345678", "text/plain".toMediaTypeOrNull())
//        val file = File("path/to/file") // здесь путь к файлу который ты будешь грузить
//        val fileBody = RequestBody.create("image/png".toMediaTypeOrNull(), file)
//        val image_file = MultipartBody.Part.createFormData("image_file", file.name, fileBody)
//        val callUploadFile = retrofitService.uploadFile(username, nickname, image_file, password)
//        val call = retrofitService.signUp(user)
//
//
//       call.enqueue(object : Callback<SignUpResponse>{
//           override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
//              return createNewUserLiveData.postValue(response.body())
//           }
//           override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
//              return createNewUserLiveData.postValue(null)
//           }
//
//       })
//return createNewUserLiveData
//
//        }


//if (response.isSuccessful) Resource.success(response.body()?.items) else Resource.error(
//response.message(), response.body()?.items, response.code()
//)





