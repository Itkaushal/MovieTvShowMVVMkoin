package com.app.kaushalprajapati.movieandshowsapp.apiservice

import com.app.kaushalprajapati.movieandshowsapp.model.WatchmodeResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WatchmodeApiService {
    @GET("v1/list-titles/")
    fun getMovies(
        @Query("types") types: String = "movie",
        @Query("apiKey") apiKey: String
    ): Single<WatchmodeResponse>

    @GET("v1/list-titles/")
    fun getTvShows(
        @Query("types") types: String = "tv_special",
        @Query("apiKey") apiKey: String
    ): Single<WatchmodeResponse>
}
