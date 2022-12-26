package com.agustintormun.tmdbclient.domain.usecase

import com.agustintormun.tmdbclient.data.model.tv.TVShow
import com.agustintormun.tmdbclient.domain.repository.TVShowRepository

class UpdateTVShowsUseCase(private val tvShowRepository: TVShowRepository) {
    suspend fun execute():List<TVShow>? = tvShowRepository.updateTVShows()
}