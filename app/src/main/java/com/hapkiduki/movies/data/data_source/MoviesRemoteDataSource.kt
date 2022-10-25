package com.hapkiduki.movies.data.data_source

import com.hapkiduki.movies.common.Constants
import com.hapkiduki.movies.data.models.Movies
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesRemoteDataSource {

    @GET("${Constants.NOW_PLAYING_URL}?api_key=${Constants.API_KEY}")
    suspend fun getPlayingNow(): Movies

    @GET("${Constants.POPULAR_URL}?api_key=${Constants.API_KEY}")
    suspend fun getPopular(): Movies

    @GET("${Constants.GET_MOVIE_DETAIL_URL}?api_key=${Constants.API_KEY}")
    suspend fun getMovieDetail(@Path("id") id: String)

    @GET("${Constants.GET_CAST_URL}?api_key=${Constants.API_KEY}")
    suspend fun getCast(@Path("id") id: String)

    @GET("${Constants.GET_VIDEOS_URL}?api_key=${Constants.API_KEY}")
    suspend fun getVideos(@Path("id") id: String)

    @GET("${Constants.SEARCH_MOVIE_URL}?api_key=${Constants.API_KEY}")
    suspend fun searchMovie(@Query("query") query: String)
}