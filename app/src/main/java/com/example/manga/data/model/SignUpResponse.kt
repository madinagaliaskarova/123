package com.example.manga.data.model

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("username")
    val username: String
)