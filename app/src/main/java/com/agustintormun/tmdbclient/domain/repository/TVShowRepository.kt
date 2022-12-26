package com.agustintormun.tmdbclient.domain.repository

import com.agustintormun.tmdbclient.data.model.tv.TVShow

interface TVShowRepository {
    suspend fun getTVShows(): List<TVShow>?
    suspend fun updateTVShows(): List<TVShow>?
}