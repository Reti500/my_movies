package com.example.shared.movies.core

import com.example.mymovies.base.data.Resource
import com.example.mymovies.entities.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getTopRatedMovies() : Flow<Resource<List<Movie>>>
}