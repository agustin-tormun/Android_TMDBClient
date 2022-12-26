package com.agustintormun.tmdbclient.data.repository.tvshow.datasource

import com.agustintormun.tmdbclient.data.model.tv.TVShow

interface TVShowLocalDataSource {
    suspend fun getTVShowsFromDB(): List<TVShow>
    suspend fun saveTVShowsToDB(tvShows: List<TVShow>)
    suspend fun clearAllTVShows()
}