package com.example.manga.d

import com.example.manga.data.remotedb.networkModule
import com.example.manga.di.repoModules
import com.example.manga.di.viewModules

val koinModules = listOf(
    repoModules, viewModules, networkModule
)
