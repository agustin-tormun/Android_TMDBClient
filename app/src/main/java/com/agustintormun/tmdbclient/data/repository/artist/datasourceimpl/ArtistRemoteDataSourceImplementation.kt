package com.agustintormun.tmdbclient.data.repository.artist.datasourceimpl

import com.agustintormun.tmdbclient.data.api.TMDBService
import com.agustintormun.tmdbclient.data.model.artist.ArtistList
import com.agustintormun.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImplementation(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}