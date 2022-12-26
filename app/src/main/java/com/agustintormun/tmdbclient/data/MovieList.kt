package com.agustintormun.tmdbclient.data


import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)