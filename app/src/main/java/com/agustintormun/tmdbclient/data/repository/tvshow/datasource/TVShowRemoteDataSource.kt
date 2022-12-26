package com.agustintormun.tmdbclient.data.repository.tvshow.datasource

import com.agustintormun.tmdbclient.data.model.tv.TVShowsList
import retrofit2.Response

interface TVShowRemoteDataSource {
    suspend fun getTVShows(): Response<TVShowsList>
}