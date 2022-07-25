package com.example.mymovies.base.data

import android.util.Log
import com.example.mymovies.base.errors.RemoteDataError
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.lang.Exception

abstract class BaseDataSource {
    protected suspend fun <I, O> getResult(
        mapper: Mapper<I, O>,
        call: suspend () -> Response<I>
    ) : O {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    return mapper(body)
                }
            }

            throw Exception("my error")
        } catch (t: Throwable) {
            Log.e("PREV Throwable", t.stackTraceToString())
            when(t) {
                is IOException -> throw RemoteDataError.NetWorkError
                is HttpException -> throw RemoteDataError.HttpError(t.code(), t.message())
                else -> throw RemoteDataError.UnknownError
            }
        }
    }
}