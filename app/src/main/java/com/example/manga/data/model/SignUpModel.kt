package com.example.manga.data.model

import com.google.gson.annotations.SerializedName

data class SignUpModel(
    @SerializedName("image_file")
    val image_file: String,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String
)