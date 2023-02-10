package com.example.manga.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.manga.data.common.Resource
import com.example.manga.data.model.SignUpModel
import com.example.manga.data.model.SignUpResponse
import com.example.manga.data.remotedb.ApiService
import kotlinx.coroutines.Dispatchers
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class SignUpRepo(private val apiService: ApiService) {

//    private val apiService: ApiService by lazy {
//        RetrofitClient.create()
//    }

//    fun signUpFun(user: SignUpModel): LiveData<Resource<SignUpResponse>> {
////        return signUp()
//    }

//    fun signUp(): LiveData<Resource<SignUpResponse>> {
//
////        val retrofitService = apiService
//        val username = RequestBody.create("madina12345678", "text/plain".toMediaTypeOrNull())
//        val file = File("path/to/file") // здесь путь к файлу который ты будешь грузить
//
//        val fileBody = RequestBody.create("image/png".toMediaTypeOrNull(), file)
//        val image_file = MultipartBody.Part.createFormData("image_file", file.name, fileBody)
//
//        val callUploadFile = apiService.uploadFile(username, nickname, image_file, password)
//        val call = apiService.signUp(user)
//
//        return liveData(Dispatchers.IO) {
//            val response =
//                apiService.signUp(SignUpModel("Madina", "Madina", "Koshka", "Madina"))
//            emit(
//                if (response.isSuccessful) Resource.success(response.body()) else Resource.error(
//                    response.message(), response.body(), response.code()
//                )
//            )
//        }
//    }
}

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
