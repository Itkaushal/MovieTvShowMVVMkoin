package com.app.kaushalprajapati.movieandshowsapp.model

data class WatchmodeResponse(
    val titles: List<Title>
)

data class Title(
    val id: Int,
    val title: String?,
    val year: Int?,
    val description: String?,
    val poster: String?,
    val type: String?,
    val imdb_id: String?,
    val tmdb_id: String?

)
