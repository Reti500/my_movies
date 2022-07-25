package com.example.mymovies.shared.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mymovies.entities.MovieDetail

@Dao
interface MovieDetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOne(mDetail: MovieDetail)

    @Query("SELECT * FROM movie_details WHERE id = :movieId")
    fun get(movieId: Int): LiveData<MovieDetail>
}