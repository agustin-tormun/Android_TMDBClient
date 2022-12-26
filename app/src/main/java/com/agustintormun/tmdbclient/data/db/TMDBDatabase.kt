package com.agustintormun.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.agustintormun.tmdbclient.data.model.artist.Artist
import com.agustintormun.tmdbclient.data.model.movie.Movie
import com.agustintormun.tmdbclient.data.model.tv.TVShow

@Database(entities = [Movie::class, TVShow::class, Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TVShowDao
    abstract fun artistDao(): ArtistDao
}