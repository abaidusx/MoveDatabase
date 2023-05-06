package com.example.moviedatabase.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedatabase.models.Movie
import com.example.moviedatabase.source.network.MovieRepository
import com.example.moviedatabase.source.network.ResponseState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
        get() = _movieList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private fun onError(error: String) {
        _errorMessage.value = error
        _isLoading.value = false
        _movieList.postValue(emptyList())
    }


    fun getUpcomingMovies() {
        viewModelScope.launch {
            Log.d("Thread Inside", Thread.currentThread().name)
            _isLoading.value = true
            when (val response = movieRepository.getUpcomingMovies()) {
                is ResponseState.Success -> {
                    _movieList.postValue(response.data.results)
                    _errorMessage.value = ""
                    _isLoading.value = false
                }
                is ResponseState.Error -> {
                    onError(response.response.message())
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        _errorMessage.value = ""

    }
}