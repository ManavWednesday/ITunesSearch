package com.example.itunesapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(listOf(remoteApiModule, databaseModule, repository, viewModel))
        }

    }

}