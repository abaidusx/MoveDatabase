package com.example.moviedatabase.source.network

import com.example.moviedatabase.models.UpcomingMovies

class MovieRepository(private val apiHelper: ApiHelper) {

    suspend fun getUpcomingMovies(): ResponseState<UpcomingMovies> {
        return apiHelper.getUpcomingMovies().parseResponse()
    }
}