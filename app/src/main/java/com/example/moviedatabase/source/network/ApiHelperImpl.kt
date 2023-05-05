package com.example.moviedatabase.source.network

class ApiHelperImpl(private  val apiService: ApiService): ApiHelper {

    override suspend fun getUpcomingMovies() = apiService.getUpcomingMovies()
}