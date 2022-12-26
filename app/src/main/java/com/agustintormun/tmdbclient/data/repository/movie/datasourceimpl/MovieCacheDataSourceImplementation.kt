package com.agustintormun.tmdbclient.data.repository.movie.datasourceimpl

import com.agustintormun.tmdbclient.data.model.movie.Movie
import com.agustintormun.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImplementation : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun getMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}