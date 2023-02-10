package com.example.manga.data.model

import com.google.gson.annotations.SerializedName

data class MangaModelPage (

    @SerializedName("results")
    val results: List<MangaModel>

    )