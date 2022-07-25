package com.example.shared.movies.data.responses

import com.google.gson.annotations.SerializedName

data class CompanyData(
    @SerializedName("id")
    val id: Int,

    @SerializedName("logo_path")
    val logoPath: String?,

    @SerializedName("name")
    val name: String,

    @SerializedName("origin_country")
    val originalCountry: String
)
