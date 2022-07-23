package com.example.mymovies.movies.presentation

import com.example.mymovies.base.Resource
import com.example.mymovies.entities.Movie
import com.example.mymovies.movies.core.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopRatedMovies @Inject constructor(
    private val repository: MoviesRepository
) {
    operator fun invoke() : Flow<Resource<List<Movie>>> {
        return repository.getTopMovies()
    }
}