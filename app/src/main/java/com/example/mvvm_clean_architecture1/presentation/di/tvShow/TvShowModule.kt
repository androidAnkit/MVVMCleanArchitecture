package com.example.mvvm_clean_architecture1.presentation.di.tvShow

import com.example.mvvm_clean_architecture1.domain.usecase.GetTvShowsUsecase
import com.example.mvvm_clean_architecture1.domain.usecase.UpdateTvShowsUsecase
import com.example.mvvm_clean_architecture1.presentation.tvshows.TvShowViewModel
import com.example.mvvm_clean_architecture1.presentation.tvshows.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule() {
    @TvShowScope
    @Provides
    fun tvShowViewModelFactoryProvider(
        getTvShowsUsecase: GetTvShowsUsecase,
        updateTvShowsUsecase: UpdateTvShowsUsecase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUsecase, updateTvShowsUsecase)
    }
}