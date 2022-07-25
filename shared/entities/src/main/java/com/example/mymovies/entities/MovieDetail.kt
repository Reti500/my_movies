package com.example.mymovies.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie_details")
data class MovieDetail(
    @SerializedName("id")
    @PrimaryKey
    val id: Int,

    @SerializedName("backdrop_path")
    val backdropPath: String?,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("vote_average")
    val voteAverage: Float,
)
