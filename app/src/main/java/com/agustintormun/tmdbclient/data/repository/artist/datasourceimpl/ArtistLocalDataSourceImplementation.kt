package com.agustintormun.tmdbclient.data.repository.artist.datasourceimpl

import com.agustintormun.tmdbclient.data.db.ArtistDao
import com.agustintormun.tmdbclient.data.model.artist.Artist
import com.agustintormun.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImplementation(private val artistDao: ArtistDao) :
    ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch { artistDao.saveArtists(artists) }
    }

    override suspend fun clearAllArtists() {
        CoroutineScope(Dispatchers.IO).launch { artistDao.deleteAllArtists() }
    }
}