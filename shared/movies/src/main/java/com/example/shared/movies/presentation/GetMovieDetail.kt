package com.example.shared.movies.presentation

import com.example.mymovies.base.data.Resource
import com.example.mymovies.entities.MovieDetail
import com.example.shared.movies.core.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieDetail @Inject constructor(
    private val repository: MoviesRepository
) {
    operator fun invoke(id: Int) : Flow<Resource<MovieDetail>> =
        repository.getMovieDetail(id)
}