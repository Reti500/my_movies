package com.example.mymovies.shared.local.di

import android.content.Context
import com.example.mymovies.shared.local.db.MoviesDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = MoviesDB.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideMoviesDao(db: MoviesDB) = db.moviesDao()

    @Singleton
    @Provides
    fun provideMovieDetailDao(db: MoviesDB) = db.movieDetailDao()
}