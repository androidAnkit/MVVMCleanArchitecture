package com.example.mvvm_clean_architecture1.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_clean_architecture1.domain.usecase.GetTvShowsUsecase
import com.example.mvvm_clean_architecture1.domain.usecase.UpdateTvShowsUsecase

class TvShowViewModelFactory
    (
    private val getTvShowsUsecase: GetTvShowsUsecase,
    private val updateTvShowsUsecase: UpdateTvShowsUsecase
            ): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUsecase, updateTvShowsUsecase) as T
    }
}