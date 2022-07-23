package com.example.mymovies.base

sealed class Resource<T>(
    val data: T? = null,
    val respCode: Int? = null,
    val message: String? = null
) {
    class Done<T>(data: T) : Resource<T>(data)
    class Failure<T>(code: Int, message: String, data: T? = null) : Resource<T>(data, code, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class NetworkError<T> : Resource<T>()
}