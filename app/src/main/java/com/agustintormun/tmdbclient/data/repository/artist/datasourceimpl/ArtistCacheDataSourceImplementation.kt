package com.agustintormun.tmdbclient.data.repository.artist.datasourceimpl

import com.agustintormun.tmdbclient.data.model.artist.Artist
import com.agustintormun.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImplementation : ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun getArtistToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}