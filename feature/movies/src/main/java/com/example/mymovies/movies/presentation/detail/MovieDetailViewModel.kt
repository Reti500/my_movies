package com.example.mymovies.movies.presentation.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovies.base.data.Resource
import com.example.mymovies.entities.MovieDetail
import com.example.shared.movies.presentation.GetMovieDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetail: GetMovieDetail
) : ViewModel() {

    private val _movie = MutableLiveData<MovieDetail>()
    val movie: LiveData<MovieDetail> = _movie

    fun getMovie(id: Int) {
        getMovieDetail(id).onEach { result ->
            when(result) {
                is Resource.Done -> {
                    result.data?.let { _movie.value = it }
                }
                is Resource.Failure -> Log.e("MoviesVM", "Failure")
                is Resource.Loading -> Log.e("MoviesVM", "Load")
                is Resource.NetworkError -> Log.e("MoviesVM", "Net Error ${result.message}")
            }
        }.launchIn(viewModelScope)
    }
}