package com.hapkiduki.movies.domain.repositories

import com.hapkiduki.movies.data.models.Movies

interface MovieRepository {
    suspend fun getPlayingNow(): Movies
    suspend fun getPopular(): Movies

    //TODO: Pendiente agregar los otros metodos
    /*suspend fun getMovieDetail(id: String)
    suspend fun getCast(id: String)
    suspend fun getVideos(id: String)
    suspend fun searchMovie(query: String)*/
}