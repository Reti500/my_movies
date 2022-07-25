package com.example.shared.movies.data.repository

import com.example.mymovies.base.data.Resource
import com.example.mymovies.base.errors.RemoteDataError
import com.example.mymovies.entities.Movie
import com.example.mymovies.entities.utils.MovieCategory
import com.example.mymovies.shared.local.dao.MovieDetailDao
import com.example.mymovies.shared.local.dao.MoviesDao
import com.example.shared.movies.core.MoviesRemoteDataSource
import com.example.shared.movies.core.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MoviesRepositoryImp @Inject constructor(
    private val remoteDataSource: MoviesRemoteDataSource,
    private val moviesDao: MoviesDao,
    private val movieDetailDao: MovieDetailDao
) : MoviesRepository {

    override fun getTopRatedMovies(): Flow<Resource<List<Movie>>> = flow<Resource<List<Movie>>> {
        emit(Resource.Loading())
        emit(Resource.Done(data = moviesDao.getAll(MovieCategory.TopRated.name)))

        try {
            val remoteData = remoteDataSource.getTopRatedMovies()

            moviesDao.insertAll(remoteData.map { m -> m.copy(category = MovieCategory.TopRated.name) })

            emit(Resource.Done(data = remoteData))
        } catch (t: Throwable) {
            when(t) {
                is RemoteDataError.NetWorkError -> emit(Resource.NetworkError())
                else -> emit(Resource.Failure(0, "", emptyList()))
            }
        }
    }.flowOn(Dispatchers.IO)

}