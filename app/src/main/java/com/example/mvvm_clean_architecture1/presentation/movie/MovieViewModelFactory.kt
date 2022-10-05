package com.example.mvvm_clean_architecture1.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_clean_architecture1.domain.usecase.GetMoviesUsecase
import com.example.mvvm_clean_architecture1.domain.usecase.UpdateMoviesUsecase

class MovieViewModelFactory
    (
    private val getMoviesUsecase: GetMoviesUsecase,
    private val updateMoviesUsecase: UpdateMoviesUsecase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUsecase, updateMoviesUsecase) as T
    }
}