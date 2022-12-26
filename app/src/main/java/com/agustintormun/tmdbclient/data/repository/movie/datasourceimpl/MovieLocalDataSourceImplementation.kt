package com.agustintormun.tmdbclient.data.repository.movie.datasourceimpl

import com.agustintormun.tmdbclient.data.db.MovieDao
import com.agustintormun.tmdbclient.data.model.movie.Movie
import com.agustintormun.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImplementation(private val movieDao: MovieDao) : MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getMovies()
    }


    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAllMovies() {
        CoroutineScope(Dispatchers.IO).launch { movieDao.deleteAllMovies() }
    }
}