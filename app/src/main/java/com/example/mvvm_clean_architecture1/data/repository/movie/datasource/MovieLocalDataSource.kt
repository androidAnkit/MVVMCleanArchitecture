package com.example.mvvm_clean_architecture1.data.repository.movie.datasource

import com.example.mvvm_clean_architecture1.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB():List<Movie>?
    suspend fun saveMoviesToDB(movies: List<Movie>?)
    suspend fun clearAll()
}