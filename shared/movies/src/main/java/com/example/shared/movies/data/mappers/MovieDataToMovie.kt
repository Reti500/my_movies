package com.example.shared.movies.data.mappers

import com.example.mymovies.base.data.Mapper
import com.example.mymovies.entities.Movie
import com.example.shared.movies.data.responses.MoviesResponse

fun mapMovieResponseToMovies() : Mapper<MoviesResponse, List<Movie>> = { resp ->
    resp.results.map {
        Movie(
            id = it.id,
            posterPath = it.posterPath,
            title = it.title,
            voteAverage = it.voteAverage,
            category = ""
        )
    }
}