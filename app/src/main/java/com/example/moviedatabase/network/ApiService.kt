package com.example.moviedatabase.network

import com.example.moviedatabase.network.models.Movie
import retrofit2.http.GET

interface ApiService {

    @GET("x/upcoming")
    suspend fun getUpcomingMovies(): List<Movie>
}