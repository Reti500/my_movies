package com.example.mymovies.movies.presentation.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovies.base.data.Resource
import com.example.mymovies.entities.Movie
import com.example.shared.movies.presentation.GetNowPlayingMovies
import com.example.shared.movies.presentation.GetTopRatedMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    val getTopRatedMovies: GetTopRatedMovies,
    val getNowPlayingMovies: GetNowPlayingMovies
) : ViewModel() {

    private val _topRatedMovies = MutableLiveData<List<Movie>>()
    val topRatedMovies : LiveData<List<Movie>> = _topRatedMovies

    private val _nowPlayingMovies = MutableLiveData<List<Movie>>()
    val nowPlayingMovies : LiveData<List<Movie>> = _nowPlayingMovies

    fun loadTopRatedMovies() {
        getTopRatedMovies().onEach { result ->
            when(result) {
                is Resource.Done -> {
                    result.data?.let { _topRatedMovies.value = it }
                }
                is Resource.Failure -> Log.e("MoviesVM", "Failure")
                is Resource.Loading -> Log.e("MoviesVM", "Load")
                is Resource.NetworkError -> Log.e("MoviesVM", "Net Error ${result.message}")
            }
        }.launchIn(viewModelScope)
    }

    fun loadNowPlayingMovies() {
        getNowPlayingMovies().onEach { result ->
            when(result) {
                is Resource.Done -> {
                    result.data?.let { _nowPlayingMovies.value = it }
                }
                is Resource.Failure -> Log.e("MoviesVM", "Failure")
                is Resource.Loading -> Log.e("MoviesVM", "Load")
                is Resource.NetworkError -> Log.e("MoviesVM", "Net Error ${result.message}")
            }
        }.launchIn(viewModelScope)
    }
}