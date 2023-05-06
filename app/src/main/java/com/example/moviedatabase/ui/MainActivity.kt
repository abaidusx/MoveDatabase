package com.example.moviedatabase.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.moviedatabase.models.Movie
import com.example.moviedatabase.source.network.ApiHelperImpl
import com.example.moviedatabase.source.network.MovieRepository
import com.example.moviedatabase.source.network.RetrofitBuilder
import com.example.moviedatabase.ui.UpcomingMovie.UpcomingMovieItem
import com.example.moviedatabase.ui.comman.ErrorView
import com.example.moviedatabase.ui.comman.InfiniteLoadingProgress
import com.example.moviedatabase.ui.theme.MovieDatabaseTheme

class MainActivity : ComponentActivity() {
    lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val apiHelper = ApiHelperImpl(RetrofitBuilder.apiService)
        val movieRepository = MovieRepository(apiHelper)

        viewModel = ViewModelProvider(
            this,
            MovieViewModelFactory(movieRepository)
        )[MovieViewModel::class.java]

        setContent {
            MovieDatabaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val movieList by viewModel.movieList.observeAsState()
                    val error by viewModel.errorMessage.observeAsState()
                    val isLoading by viewModel.isLoading.observeAsState()
                    when{
                        movieList?.isNotEmpty() == true -> MovieList(list = movieList)
                        isLoading == true -> InfiniteLoadingProgress()
                        error?.isNotEmpty() == true -> ErrorView()
                    }

                }
            }
        }

        viewModel.getUpcomingMovies()
    }

    @Composable
    fun MovieList(list: List<Movie>?) {
        Box {
            list?.let {
                LazyColumn {
                    items(it) {
                        UpcomingMovieItem(it)
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MovieDatabaseTheme {
            MovieList(emptyList())
        }
    }
}