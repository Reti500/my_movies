package com.example.mymovies.movies.core.repository

import com.example.mymovies.base.Resource
import com.example.mymovies.entities.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getTopMovies() : Flow<Resource<List<Movie>>>
}