package com.example.moviedatabase.source.network

import com.example.moviedatabase.models.Movie

interface ApiHelper {

    suspend fun getUpcomingMovies(): List<Movie>

}