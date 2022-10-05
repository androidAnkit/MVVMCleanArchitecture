package com.example.mvvm_clean_architecture1.domain.repository

import com.example.mvvm_clean_architecture1.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}