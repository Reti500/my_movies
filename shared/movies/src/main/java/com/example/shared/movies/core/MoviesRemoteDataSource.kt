package com.example.shared.movies.core

import com.example.mymovies.entities.Movie
import com.example.mymovies.entities.MovieDetail

interface MoviesRemoteDataSource {
    suspend fun getTopRatedMovies() : List<Movie>
    suspend fun getNowPlayingMovies() : List<Movie>
    suspend fun getMovieDetail(id: Int) : MovieDetail
}