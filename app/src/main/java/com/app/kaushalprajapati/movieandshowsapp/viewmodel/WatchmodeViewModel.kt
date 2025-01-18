package com.app.kaushalprajapati.movieandshowsapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.app.kaushalprajapati.movieandshowsapp.model.Title
import com.app.kaushalprajapati.movieandshowsapp.repository.WatchmodeRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo

class WatchmodeViewModel(private val repository: WatchmodeRepository) : ViewModel() {

    val movies = mutableStateOf<List<Title>>(emptyList())
    val tvShows = mutableStateOf<List<Title>>(emptyList())
    val isLoading = mutableStateOf(true)
    val errorMessage = mutableStateOf<String?>(null)

    private val disposable = CompositeDisposable()

    fun fetchData(apiKey: String) {
        isLoading.value = true
        Single.zip(
            repository.fetchMovies(apiKey),
            repository.fetchTvShows(apiKey)
        ) { moviesResponse, tvShowsResponse ->
            Pair(moviesResponse.titles, tvShowsResponse.titles)
        }.subscribe({ (moviesList, tvShowsList) ->
            movies.value = moviesList
            tvShows.value = tvShowsList
            isLoading.value = false
        }, { error ->
            errorMessage.value = error.localizedMessage
            isLoading.value = false
        }).addTo(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
