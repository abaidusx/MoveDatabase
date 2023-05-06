package com.example.moviedatabase.models

data class UpcomingMovies(
    val page: Int,
    val next: String,
    val entries: Int,
    val results: List<Movie>
)
