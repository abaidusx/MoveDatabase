package com.example.moviedatabase.source.network

import com.example.moviedatabase.models.Movie
import retrofit2.http.GET

interface ApiService {

    @GET("x/upcoming")
    suspend fun getUpcomingMovies(): List<Movie>
}