package com.example.shared.movies.core

import com.example.mymovies.base.data.Resource
import com.example.mymovies.entities.Movie
import com.example.mymovies.entities.MovieDetail
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getTopRatedMovies() : Flow<Resource<List<Movie>>>
    fun getNowPlayingMovies() : Flow<Resource<List<Movie>>>
    fun getMovieDetail(id: Int) : Flow<Resource<MovieDetail>>
}