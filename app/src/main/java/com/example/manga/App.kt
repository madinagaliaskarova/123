package com.example.manga

import android.app.Application
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.manga.d.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    companion object {

        const val BASE_URL = "http://134.122.75.14:8666/api/"
        val USER_NAME_KEY = stringPreferencesKey("USER_NAME")
        val USER_PASSWORD_KEY = stringPreferencesKey("USER_PASSWORD")
        const val MAX_PAGE_SIZE = "20"
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(koinModules)
        }
    }
}

