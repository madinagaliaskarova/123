package com.example.manga.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.manga.data.common.Resource
import com.example.manga.data.model.SignUpModel
import com.example.manga.data.model.SignUpResponse
import com.example.manga.data.remotedb.ApiService
import kotlinx.coroutines.Dispatchers

class SignUpRepository {

//        private val apiService: ApiService by lazy {
//            RetrofitClient.create()
//        }
//
//        fun signUpFun(): LiveData<Resource<SignUpResponse>> {
//            return signUp()
//        }
//
//        fun signUp(): LiveData<Resource<SignUpResponse>> {
//            return liveData(Dispatchers.IO) {
//                val response =
//                    apiService.signUp(SignUpModel("Madina", "Madina", "Koshka", "Madina"))
//                emit(
//                    if (response.isSuccessful) Resource.success(response.body()) else Resource.error(
//                        response.message(), response.body(), response.code()
//                    )
//                )
//            }
//        }
//    }

//    loginResult.value = BaseResponse.Loading()
//    viewModelScope.launch {
//        try {
//
//            val loginRequest = LoginRequest(
//                password = pwd,
//                email = email
//            )
//            val response = userRepo.loginUser(loginRequest = loginRequest)
//            if (response?.code() == 200) {
//                loginResult.value = BaseResponse.Success(response.body())
//            } else {
//                loginResult.value = BaseResponse.Error(response?.message())
//            }
//
//        } catch (ex: Exception) {
//            loginResult.value = BaseResponse.Error(ex.message)
//        }
//    } удалить?
//
//
//    private val apiService: ApiService
//
//    init {
//        apiService = Constants.getApiService
//    }
//
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
}





