package com.example.manga.di

import com.example.manga.ui.fragment.detailedmanga.DetailedMangaViewModel
import com.example.manga.ui.fragment.tablayoutmanga.manga.MangaViewModel
import com.example.manga.ui.fragment.tablayoutmanga.topmanga.MangaTopViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModules = module {
    viewModel { MangaViewModel(get(), get()) }
    viewModel { MangaTopViewModel(get()) }
    viewModel { DetailedMangaViewModel(get()) }

}