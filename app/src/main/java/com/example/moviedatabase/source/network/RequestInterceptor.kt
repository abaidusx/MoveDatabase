package com.example.moviedatabase.source.network

import okhttp3.Interceptor
import okhttp3.Response


object RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        println("Outgoing request to url: ${request.url}, headers: ${request.headers.map { "${it.first}: ${it.second}"}}")
        return chain.proceed(request)
    }
}