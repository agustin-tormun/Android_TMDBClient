package com.agustintormun.tmdbclient.data.repository.artist.datasource

import com.agustintormun.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}