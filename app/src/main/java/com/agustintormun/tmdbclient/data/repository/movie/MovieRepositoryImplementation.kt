package com.agustintormun.tmdbclient.data.repository.movie

import android.util.Log
import com.agustintormun.tmdbclient.data.model.movie.Movie
import com.agustintormun.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.agustintormun.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.agustintormun.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.agustintormun.tmdbclient.domain.repository.MovieRepository

class MovieRepositoryImplementation(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAllMovies()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.getMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (exception: Exception) {
            Log.i(
                "MyTag", exception.message.toString()
            )
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (movieList.isEmpty()) {
            movieList = getMoviesFromDB()
            movieCacheDataSource.getMoviesToCache(movieList)
        }

        return movieList
    }
}