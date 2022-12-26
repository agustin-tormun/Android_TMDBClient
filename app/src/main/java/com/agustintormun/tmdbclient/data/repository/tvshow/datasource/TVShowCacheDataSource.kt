package com.agustintormun.tmdbclient.data.repository.tvshow.datasource

import com.agustintormun.tmdbclient.data.model.tv.TVShow

interface TVShowCacheDataSource {
    suspend fun getTVShowsFromCache(): List<TVShow>
    suspend fun getTVShowsToCache(tvShows: List<TVShow>)
}