package com.agustintormun.tmdbclient.data.repository.movie.datasource

import com.agustintormun.tmdbclient.data.model.movie.Movie
import com.agustintormun.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}