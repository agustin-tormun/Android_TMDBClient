package com.agustintormun.tmdbclient.domain.usecase

import com.agustintormun.tmdbclient.data.model.movie.Movie
import com.agustintormun.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}