package com.example.mvvm_clean_architecture1.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvm_clean_architecture1.domain.usecase.GetTvShowsUsecase
import com.example.mvvm_clean_architecture1.domain.usecase.UpdateArtistUsecase
import com.example.mvvm_clean_architecture1.domain.usecase.UpdateTvShowsUsecase

class TvShowViewModel
    (
    private val getTvShowsUsecase: GetTvShowsUsecase,
    private val updateTvShowsUsecase: UpdateTvShowsUsecase
) : ViewModel() {

    fun getTvShows() = liveData {
        val tvShowList = getTvShowsUsecase.execute()
        emit(tvShowList)
    }

    fun updateTvsShow() = liveData {
        val tvShowList = updateTvShowsUsecase.execute()
        emit(tvShowList)
    }
}