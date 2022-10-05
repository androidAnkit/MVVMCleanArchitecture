package com.example.mvvm_clean_architecture1.domain.usecase

import com.example.mvvm_clean_architecture1.data.model.tvShows.TvShow
import com.example.mvvm_clean_architecture1.domain.repository.TvShowsRepository

class UpdateTvShowsUsecase(private val tvShowsRepository: TvShowsRepository) {
    suspend fun execute():List<TvShow>? = tvShowsRepository.updateTvShows()
}