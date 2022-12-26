package com.agustintormun.tmdbclient.data.repository.artist.datasource

import com.agustintormun.tmdbclient.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearAllArtists()
}