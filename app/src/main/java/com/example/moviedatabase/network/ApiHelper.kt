package com.example.moviedatabase.network

import com.example.moviedatabase.network.models.Movie

interface ApiHelper {

    suspend fun getUpcomingMovies(): List<Movie>

}