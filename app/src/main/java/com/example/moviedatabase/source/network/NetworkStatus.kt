package com.example.moviedatabase.source.network

import retrofit2.Response

sealed class ResponseState<out T> {
    data class Success<out T>(val data: T): ResponseState<T>()
    data class Error<T>(val response: Response<T>): ResponseState<T>()
}

fun <T> Response<T>.parseResponse(): ResponseState<T> {
    return if (this.isSuccessful && this.body() != null) {
        val responseBody = this.body()
        ResponseState.Success(responseBody!!)
    } else {
        ResponseState.Error(this)
    }
}