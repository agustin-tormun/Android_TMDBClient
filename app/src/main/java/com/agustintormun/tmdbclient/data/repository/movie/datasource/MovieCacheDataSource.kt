package com.agustintormun.tmdbclient.data.repository.movie.datasource

import com.agustintormun.tmdbclient.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun getMoviesToCache(movies: List<Movie>)
}