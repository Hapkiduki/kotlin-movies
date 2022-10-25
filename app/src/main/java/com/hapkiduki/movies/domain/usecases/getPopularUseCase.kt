package com.hapkiduki.movies.domain.usecases

import com.hapkiduki.movies.common.Resource
import com.hapkiduki.movies.data.models.toMovie
import com.hapkiduki.movies.domain.entities.Movie
import com.hapkiduki.movies.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPopularUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading<List<Movie>>())
            val movies = repository.getPopular().results.map { it.toMovie() }
            emit(Resource.Success<List<Movie>>(movies))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<Movie>>(
                    e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error<List<Movie>>(
                    "Couldn't reach server. Check your internet connection."
                )
            )
        }
    }
}