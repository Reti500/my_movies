package com.example.shared.movies.data.responses

import com.google.gson.annotations.SerializedName

data class CountryData(
    @SerializedName("iso_3166_1")
    val iso: String,

    @SerializedName("name")
    val name: String
)
