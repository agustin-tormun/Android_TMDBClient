package com.agustintormun.tmdbclient.data.repository.artist.datasource

import com.agustintormun.tmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache(): List<Artist>
    suspend fun getArtistToCache(artists: List<Artist>)
}