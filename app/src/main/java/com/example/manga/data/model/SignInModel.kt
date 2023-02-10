package com.example.manga.data.model

import com.google.gson.annotations.SerializedName

data class SignInModel(

    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String

)



