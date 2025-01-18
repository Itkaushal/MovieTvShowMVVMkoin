package com.app.kaushalprajapati.movieandshowsapp.repository

import com.app.kaushalprajapati.movieandshowsapp.apiservice.WatchmodeApiService
import com.app.kaushalprajapati.movieandshowsapp.model.WatchmodeResponse
import io.reactivex.rxjava3.core.Single

class WatchmodeRepository(private val apiService: WatchmodeApiService) {
    fun fetchMovies(apiKey: String): Single<WatchmodeResponse> = apiService.getMovies(apiKey = apiKey)
    fun fetchTvShows(apiKey: String): Single<WatchmodeResponse> = apiService.getTvShows(apiKey = apiKey)
}
