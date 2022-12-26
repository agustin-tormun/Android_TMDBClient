package com.agustintormun.tmdbclient.domain.usecase

import com.agustintormun.tmdbclient.data.model.artist.Artist
import com.agustintormun.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}