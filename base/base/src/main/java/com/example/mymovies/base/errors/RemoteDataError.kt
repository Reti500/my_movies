package com.example.mymovies.base.errors

sealed class RemoteDataError : Throwable() {
    object NetWorkError : RemoteDataError()
    object UnknownError : RemoteDataError()

    class HttpError(val code: Int, val error: String) : RemoteDataError()
}
