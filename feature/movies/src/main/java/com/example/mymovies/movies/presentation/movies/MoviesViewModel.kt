package com.example.mymovies.movies.presentation.movies

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

    private val _originalTopRatedMovies = MutableLiveData<List<Movie>>()
    private val _topRatedMovies = MutableLiveData<List<Movie>>()
    val topRatedMovies : LiveData<List<Movie>?> = _topRatedMovies

    private val _originalNowPlayingMovies = MutableLiveData<List<Movie>>()
    private val _nowPlayingMovies = MutableLiveData<List<Movie>>()
    val nowPlayingMovies : LiveData<List<Movie>?> = _nowPlayingMovies

    fun loadTopRatedMovies() {
        getTopRatedMovies().onEach { result ->
            when(result) {
                is Resource.Done -> {
                    result.data?.let {
                        _originalTopRatedMovies.value = it
                        setFilter("")
                    }
                }
                is Resource.Failure -> {}
                is Resource.Loading -> {}
                is Resource.NetworkError -> {}
            }
        }.launchIn(viewModelScope)
    }

    fun loadNowPlayingMovies() {
        getNowPlayingMovies().onEach { result ->
            when(result) {
                is Resource.Done -> {
                    result.data?.let {
                        _originalNowPlayingMovies.value = it
                        setFilter("")
                    }
                }
                is Resource.Failure -> {}
                is Resource.Loading -> {}
                is Resource.NetworkError -> {}
            }
        }.launchIn(viewModelScope)
    }

    fun setFilter(f: String) {
        if (f.isEmpty()) {
            _topRatedMovies.value = _originalTopRatedMovies.value
            _nowPlayingMovies.value = _originalNowPlayingMovies.value
        } else {
            _topRatedMovies.value = _originalTopRatedMovies.value?.filter { m ->
                m.title.lowercase().contains(filterRegex(f.lowercase()))
            }
            _nowPlayingMovies.value = _originalNowPlayingMovies.value?.filter { m ->
                m.title.lowercase().contains(filterRegex(f.lowercase()))
            }
        }
    }

    private fun filterRegex(filter: String) =
        Regex("(?:(${filter.split(" ").joinToString(separator="|")}))")
}