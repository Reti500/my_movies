package com.example.shared.movies.data.repository

import com.example.mymovies.base.data.Resource
import com.example.mymovies.entities.Movie
import com.example.shared.movies.core.MoviesRemoteDataSource
import com.example.shared.movies.core.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MoviesRepositoryImp @Inject constructor(
    private val remoteDataSource: MoviesRemoteDataSource
) : MoviesRepository {
    override fun getTopRatedMovies(): Flow<Resource<List<Movie>>> = flow<Resource<List<Movie>>> {
        emit(Resource.Loading())
        //emit(Resource.Done(data = counterDao.getAll()))

        try {
            val remoteData = remoteDataSource.getTopRatedMovies()

            //counterDao.deleteAll()
            //counterDao.insertAll(remoteData)

            emit(Resource.Done(data = remoteData))
        } catch (t: Throwable) {
            when(t) {
                //is RemoteDataError.NetWorkError -> emit(Resource.NetworkError<List<Counter>>())
                else -> emit(Resource.Failure(0, "", emptyList()))
            }
        }
    }
}