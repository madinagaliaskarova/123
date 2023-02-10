package com.example.manga.data.model

data class MangaDetailedModel(
    val chapters_quantity: Int,
    val comments_count: Int,
    val created_at: String,
    val description: String,
    val en_name: String,
    val genre: List<Int>,
    val id: Int,
    val image: String,
    val issue_year: Int,
    val likes: Int,
    val rating: Double,
    val ru_name: String,
    val type: String
)