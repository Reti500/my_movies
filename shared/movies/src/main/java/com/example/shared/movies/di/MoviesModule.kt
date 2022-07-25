package com.example.shared.movies.di

import com.example.mymovies.shared.local.dao.MovieDetailDao
import com.example.mymovies.shared.local.dao.MoviesDao
import com.example.shared.movies.core.MoviesRemoteDataSource
import com.example.shared.movies.core.MoviesRepository
import com.example.shared.movies.core.MoviesService
import com.example.shared.movies.data.remote.MoviesRemoteDataSourceImp
import com.example.shared.movies.data.repository.MoviesRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesModule {

    @Provides
    @Singleton
    fun providesCounterService(retrofit: Retrofit): MoviesService =
        retrofit.create(MoviesService::class.java)

    @Provides
    fun providesMoviesRemoteDataSource(service: MoviesService): MoviesRemoteDataSource =
        MoviesRemoteDataSourceImp(service = service)

    @Provides
    fun providesMoviesRepository(
        remote: MoviesRemoteDataSource,
        moviesDao: MoviesDao,
        movieDetailDao: MovieDetailDao
    ): MoviesRepository =
        MoviesRepositoryImp(
            remoteDataSource = remote,
            moviesDao = moviesDao,
            movieDetailDao = movieDetailDao
        )

}