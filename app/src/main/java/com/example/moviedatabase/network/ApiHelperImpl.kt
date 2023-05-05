package com.example.moviedatabase.network

class ApiHelperImpl(private  val apiService: ApiService): ApiHelper {

    override suspend fun getUpcomingMovies() = apiService.getUpcomingMovies()
}