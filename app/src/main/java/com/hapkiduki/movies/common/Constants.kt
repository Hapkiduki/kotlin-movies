package com.hapkiduki.movies.common

import com.hapkiduki.movies.BuildConfig

object Constants {
    const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val API_KEY = BuildConfig.API_KEY
    const val NOW_PLAYING_URL = "movie/now_playing"
    const val POPULAR_URL = "movie/popular"
    const val SEARCH_MOVIE_URL = "search/movie"
    const val GET_MOVIE_DETAIL_URL = "movie/{id}"
    const val GET_CAST_URL = "movie/{id}/credits"
    const val GET_VIDEOS_URL = "movie/{id}/videos"
}