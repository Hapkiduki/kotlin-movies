package com.hapkiduki.movies.domain.entities

data class Movie(
    val id: Int,
    val backdropPath: String,
    val title: String,
    val voteAverage: Double,
    val releaseDate: String,
    val overview: String,
)
