package com.example.mvvm_clean_architecture1.data.repository.movie.datasource

import com.example.mvvm_clean_architecture1.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies():Response<MovieList>?
}