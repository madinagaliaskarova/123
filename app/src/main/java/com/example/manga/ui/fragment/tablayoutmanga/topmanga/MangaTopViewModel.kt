package com.example.manga.ui.fragment.tablayoutmanga.topmanga

import androidx.lifecycle.ViewModel
import com.example.manga.App
import com.example.manga.data.repository.Repository
import org.koin.java.KoinJavaComponent.inject

class MangaTopViewModel(private val repository: Repository) : ViewModel() {

    fun listManga() = repository.manga()

}