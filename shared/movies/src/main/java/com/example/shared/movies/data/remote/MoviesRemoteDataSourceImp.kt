package com.example.shared.movies.data.remote

import com.example.mymovies.base.data.BaseDataSource
import com.example.shared.movies.core.MoviesRemoteDataSource
import com.example.shared.movies.core.MoviesService
import com.example.shared.movies.data.mappers.mapMovieResponseToMovies

class MoviesRemoteDataSourceImp(
    private val service: MoviesService
) : MoviesRemoteDataSource, BaseDataSource() {
    override suspend fun getTopRatedMovies() = getResult(mapMovieResponseToMovies()) {
        service.getTopRatedMovies(1)
    }
}