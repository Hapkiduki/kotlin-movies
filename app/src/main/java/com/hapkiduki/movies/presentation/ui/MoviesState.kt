package com.hapkiduki.movies.presentation.ui

import com.hapkiduki.movies.domain.entities.Movie

data class MoviesState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = ""
)
