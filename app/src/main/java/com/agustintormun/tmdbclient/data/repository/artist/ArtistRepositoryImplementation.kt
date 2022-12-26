package com.agustintormun.tmdbclient.data.repository.artist

import android.util.Log
import com.agustintormun.tmdbclient.data.model.artist.Artist
import com.agustintormun.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.agustintormun.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.agustintormun.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.agustintormun.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImplementation(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) :
    ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAllArtists()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.getArtistToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (artistList.isEmpty()) {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (artistList.isEmpty()) {
            artistList = getArtistsFromDB()
            artistCacheDataSource.getArtistToCache(artistList)
        }
        return artistList
    }
}