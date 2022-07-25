package com.example.mymovies.entities.utils

sealed class MovieCategory(val name: String) {
    object TopRated : MovieCategory("topRated")
}
