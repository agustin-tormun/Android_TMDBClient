package com.agustintormun.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.agustintormun.tmdbclient.data.model.tv.TVShow

@Dao
interface TVShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TVShow>)

    @Query("DELETE FROM popular_tvshows")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM popular_tvshows")
    suspend fun getTvShows(tvShows: List<TVShow>)
}