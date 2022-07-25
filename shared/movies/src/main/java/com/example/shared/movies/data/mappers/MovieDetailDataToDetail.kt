package com.example.shared.movies.data.mappers

import com.example.mymovies.base.data.Mapper
import com.example.mymovies.entities.MovieDetail
import com.example.shared.movies.data.responses.MovieDetailData

fun mapMovieDetailDataToDetail() : Mapper<MovieDetailData, MovieDetail> = { resp ->
    MovieDetail(
        id = resp.id,
        backdropPath = resp.backdropPath,
        overview = resp.overview,
        title = resp.title,
        voteAverage = resp.voteAverage,
    )
}