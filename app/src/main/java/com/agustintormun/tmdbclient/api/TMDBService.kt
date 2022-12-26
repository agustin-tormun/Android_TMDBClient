package com.agustintormun.tmdbclient.api

import com.agustintormun.tmdbclient.data.ArtistList
import com.agustintormun.tmdbclient.data.MovieList
import com.agustintormun.tmdbclient.data.TVShowsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apiKey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTVShows(@Query("api_key")apiKey: String): Response<TVShowsList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key")apiKey: String): Response<ArtistList>
}