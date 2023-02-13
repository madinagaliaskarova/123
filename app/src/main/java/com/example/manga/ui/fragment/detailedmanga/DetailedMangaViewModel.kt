package com.example.manga.ui.fragment.detailedmanga

import androidx.lifecycle.ViewModel
import com.example.manga.data.repository.MangaDetailedRepository
import com.example.manga.data.repository.Repository

class DetailedMangaViewModel(private val repository: MangaDetailedRepository):ViewModel() {

fun idManga(id:Int) = repository.idManga(id)


}
