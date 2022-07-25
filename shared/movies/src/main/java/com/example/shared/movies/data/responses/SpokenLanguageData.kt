package com.example.shared.movies.data.responses

import com.google.gson.annotations.SerializedName

data class SpokenLanguageData(
    @SerializedName("english_name")
    val englishName: String,

    @SerializedName("iso_639_1")
    val iso: String,

    @SerializedName("name")
    val name: String
)
