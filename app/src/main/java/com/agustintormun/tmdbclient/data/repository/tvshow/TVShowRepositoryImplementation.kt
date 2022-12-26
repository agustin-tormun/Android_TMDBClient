package com.agustintormun.tmdbclient.data.repository.tvshow

import android.util.Log
import com.agustintormun.tmdbclient.data.model.tv.TVShow
import com.agustintormun.tmdbclient.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.agustintormun.tmdbclient.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.agustintormun.tmdbclient.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.agustintormun.tmdbclient.domain.repository.TVShowRepository

class TVShowRepositoryImplementation(
    private val tvShowCacheDataSource: TVShowCacheDataSource,
    private val tvShowLocalDataSource: TVShowLocalDataSource,
    private val tvShowRemoteDataSource: TVShowRemoteDataSource
) : TVShowRepository {
    override suspend fun getTVShows(): List<TVShow>? {
        return getTVShowsFromCache()
    }

    override suspend fun updateTVShows(): List<TVShow>? {
        val newListOfTVShows = getTVShowsFromAPI()
        tvShowLocalDataSource.clearAllTVShows()
        tvShowLocalDataSource.saveTVShowsToDB(newListOfTVShows)
        tvShowCacheDataSource.getTVShowsToCache(newListOfTVShows)
        return newListOfTVShows
    }

    suspend fun getTVShowsFromAPI(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>
        try {
            val response = tvShowRemoteDataSource.getTVShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.TVShows
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTVShowsFromDB(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>
        try {
            tvShowList = tvShowLocalDataSource.getTVShowsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (tvShowList.isEmpty()) {
            tvShowList = getTVShowsFromAPI()
            tvShowLocalDataSource.saveTVShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTVShowsFromCache(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>
        try {
            tvShowList = tvShowCacheDataSource.getTVShowsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (tvShowList.isEmpty()) {
            tvShowList = getTVShowsFromDB()
            tvShowCacheDataSource.getTVShowsToCache(tvShowList)
        }
        return tvShowList
    }
}