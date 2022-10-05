package com.example.mvvm_clean_architecture1.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvm_clean_architecture1.data.model.movie.Movie
import com.example.mvvm_clean_architecture1.data.model.movie.MovieList
import com.example.mvvm_clean_architecture1.domain.usecase.GetMoviesUsecase
import com.example.mvvm_clean_architecture1.domain.usecase.UpdateMoviesUsecase

class MovieViewModel
    (
    private val getMoviesUsecase: GetMoviesUsecase,
    private val updateMoviesUsecase: UpdateMoviesUsecase
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUsecase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUsecase.execute()
        emit(movieList)
    }

}