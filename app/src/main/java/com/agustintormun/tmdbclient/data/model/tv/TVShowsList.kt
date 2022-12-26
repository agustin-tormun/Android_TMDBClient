package com.agustintormun.tmdbclient.data.model.tv


import com.google.gson.annotations.SerializedName

data class TVShowsList(
    @SerializedName("results")
    val TVShows: List<TVShow>
)