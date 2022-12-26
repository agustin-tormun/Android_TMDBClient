package com.agustintormun.tmdbclient.data.repository.movie.datasource

import com.agustintormun.tmdbclient.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAllMovies()
}