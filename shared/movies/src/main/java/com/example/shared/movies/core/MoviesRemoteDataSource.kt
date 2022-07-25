package com.example.shared.movies.core

import com.example.mymovies.entities.Movie

interface MoviesRemoteDataSource {
    suspend fun getTopRatedMovies() : List<Movie>
}