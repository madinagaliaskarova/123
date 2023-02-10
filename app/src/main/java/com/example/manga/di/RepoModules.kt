package com.example.manga.di

import com.example.manga.data.repository.MangaDetailedRepository
import com.example.manga.data.repository.Repository
import com.example.manga.data.repository.SignUpRepo
import org.koin.dsl.module

val repoModules = module {

    single { Repository(get(),get()) }
//    single { SignUpRepo(get()) }
    single { MangaDetailedRepository(get()) }

}
