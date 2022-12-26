package com.agustintormun.tmdbclient.domain.repository

import com.agustintormun.tmdbclient.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies():List<Movie>?
}