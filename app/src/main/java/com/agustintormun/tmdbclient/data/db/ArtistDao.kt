package com.agustintormun.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.agustintormun.tmdbclient.data.model.artist.Artist

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists: List<Artist>)

    @Query("DELETE FROM popular_artist")
    suspend fun deleteAllArtists()

    @Query("SELECT * FROM popular_artist")
    suspend fun getArtists(): List<Artist>
}