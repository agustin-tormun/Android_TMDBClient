package com.agustintormun.tmdbclient.data


import com.google.gson.annotations.SerializedName

data class TVShowsList(
    @SerializedName("results")
    val TVShows: List<TVShow>
)