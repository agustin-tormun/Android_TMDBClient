package com.agustintormun.tmdbclient.domain.repository

import com.agustintormun.tmdbclient.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}