package com.example.moviedatabase.source.network

import com.example.moviedatabase.models.UpcomingMovies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers(
        value = [
            "X-RapidAPI-Key: 411e3c98d9msh31fb4a374cfc562p15f98bjsn90767712b8da",
            "X-RapidAPI-Host: moviesdatabase.p.rapidapi.com"
        ]
    )
    @GET("x/upcoming")
    suspend fun getUpcomingMovies(): Response<UpcomingMovies>
}