package com.agustintormun.tmdbclient.data.repository.movie.datasourceimpl

import com.agustintormun.tmdbclient.data.api.TMDBService
import com.agustintormun.tmdbclient.data.model.movie.MovieList
import com.agustintormun.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImplementation(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}