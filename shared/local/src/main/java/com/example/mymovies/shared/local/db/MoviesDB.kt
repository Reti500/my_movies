package com.example.mymovies.shared.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mymovies.entities.Movie
import com.example.mymovies.entities.MovieDetail
import com.example.mymovies.shared.local.dao.MovieDetailDao
import com.example.mymovies.shared.local.dao.MoviesDao

@Database(
    entities = [
        Movie::class,
        MovieDetail::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class MoviesDB : RoomDatabase() {

    abstract fun moviesDao() : MoviesDao
    abstract fun movieDetailDao() : MovieDetailDao

    companion object {
        @Volatile private var instance: MoviesDB? = null

        fun getDatabase(context: Context): MoviesDB =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it}}

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, MoviesDB::class.java, "movies_db")
                .fallbackToDestructiveMigration()
                .build()
    }
}