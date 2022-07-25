package com.example.mymovies.movies.presentation.movies

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovies.base.data.Resource
import com.example.shared.movies.presentation.GetTopRatedMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    val getTopRatedMovies: GetTopRatedMovies
) : ViewModel() {

    fun loadMovies() {
        Log.e("MoviesVM", "Load Movies")
        getTopRatedMovies().onEach { result ->
            when(result) {
                is Resource.Done -> Log.e("MoviesVM", "Done ${result.data}")
                is Resource.Failure -> Log.e("MoviesVM", "Failure")
                is Resource.Loading -> Log.e("MoviesVM", "Load")
                is Resource.NetworkError -> Log.e("MoviesVM", "Net Error ${result.message}")
            }
        }.launchIn(viewModelScope)
    }
}