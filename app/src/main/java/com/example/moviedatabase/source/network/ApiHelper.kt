package com.example.moviedatabase.source.network

import com.example.moviedatabase.models.UpcomingMovies
import retrofit2.Response

interface ApiHelper {

    suspend fun getUpcomingMovies(): Response<UpcomingMovies>

}