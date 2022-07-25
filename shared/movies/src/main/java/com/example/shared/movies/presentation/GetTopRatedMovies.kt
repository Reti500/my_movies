package com.example.shared.movies.presentation

import com.example.mymovies.base.data.Resource
import com.example.mymovies.entities.Movie
import com.example.shared.movies.core.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopRatedMovies @Inject constructor(
    private val repository: MoviesRepository
) {
    operator fun invoke() : Flow<Resource<List<Movie>>> =
        repository.getTopRatedMovies()
}