package com.hapkiduki.movies.data.repositories

import com.hapkiduki.movies.data.data_source.MoviesRemoteDataSource
import com.hapkiduki.movies.data.models.Movies
import com.hapkiduki.movies.domain.repositories.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MoviesRemoteDataSource
) : MovieRepository {
    override suspend fun getPlayingNow(): Movies {
        return api.getPlayingNow()
    }

    override suspend fun getPopular(): Movies {
        return api.getPlayingNow()
    }
}