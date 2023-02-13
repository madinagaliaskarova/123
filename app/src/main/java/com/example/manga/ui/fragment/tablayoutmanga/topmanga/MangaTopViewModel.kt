package com.example.manga.ui.fragment.tablayoutmanga.topmanga

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.manga.App
import com.example.manga.data.repository.Repository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import org.koin.java.KoinJavaComponent.inject

class MangaTopViewModel(private val repository: Repository) : ViewModel() {

    var query = ""

    var listMangas = repository.listMangaPaging(query).flow.stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        PagingData.empty()).cachedIn(viewModelScope)

    fun searchManga(id:String) = repository.SearchManga(id)

}