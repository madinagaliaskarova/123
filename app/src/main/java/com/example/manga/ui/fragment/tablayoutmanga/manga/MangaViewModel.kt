package com.example.manga.ui.fragment.tablayoutmanga.manga


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.manga.data.common.EverythingNewsPageSource
import com.example.manga.data.common.Resource
import com.example.manga.data.model.MangaModel
import com.example.manga.data.repository.Repository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class MangaViewModel(private val repository: Repository, everythingNewsPageSource: EverythingNewsPageSource) : ViewModel() {

    var query = ""

    var listMangas = repository.listMangaPaging(query).flow.stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        PagingData.empty()).cachedIn(viewModelScope)

    fun searchManga(id:String) = repository.SearchManga(id)

}
