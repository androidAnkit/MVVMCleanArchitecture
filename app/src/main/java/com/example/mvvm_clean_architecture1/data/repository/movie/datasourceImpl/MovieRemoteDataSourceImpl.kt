package com.example.mvvm_clean_architecture1.data.repository.movie.datasourceImpl

import com.example.mvvm_clean_architecture1.data.api.TMDBService
import com.example.mvvm_clean_architecture1.data.model.movie.MovieList
import com.example.mvvm_clean_architecture1.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl
    (
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList>? =
        tmdbService.getPopularMovies(apiKey)
}