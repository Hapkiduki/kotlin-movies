package com.hapkiduki.movies.di

import com.hapkiduki.movies.common.Constants
import com.hapkiduki.movies.data.data_source.MoviesRemoteDataSource
import com.hapkiduki.movies.data.repositories.MovieRepositoryImpl
import com.hapkiduki.movies.domain.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMoviesApi(): MoviesRemoteDataSource {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesRemoteDataSource::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: MoviesRemoteDataSource): MovieRepository {
        return MovieRepositoryImpl(api)
    }
}