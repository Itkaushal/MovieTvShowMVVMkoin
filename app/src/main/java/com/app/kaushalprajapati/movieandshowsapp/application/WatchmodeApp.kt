package com.app.kaushalprajapati.movieandshowsapp.application

import android.app.Application
import com.app.kaushalprajapati.movieandshowsapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WatchmodeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WatchmodeApp)
            modules(appModule)
        }
    }
}
