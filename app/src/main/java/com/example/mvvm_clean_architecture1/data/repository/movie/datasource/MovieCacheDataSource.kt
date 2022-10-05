package com.example.mvvm_clean_architecture1.data.repository.movie.datasource

import com.example.mvvm_clean_architecture1.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>?
    suspend fun saveMoviesToCache(movies: List<Movie>?)
}