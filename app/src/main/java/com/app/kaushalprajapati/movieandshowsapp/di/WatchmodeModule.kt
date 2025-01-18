package com.app.kaushalprajapati.movieandshowsapp.di

import com.app.kaushalprajapati.movieandshowsapp.apiservice.WatchmodeApiService
import com.app.kaushalprajapati.movieandshowsapp.repository.WatchmodeRepository
import com.app.kaushalprajapati.movieandshowsapp.viewmodel.WatchmodeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://api.watchmode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(WatchmodeApiService::class.java)
    }

    single { WatchmodeRepository(get()) }
    viewModel { WatchmodeViewModel(get()) }

}
