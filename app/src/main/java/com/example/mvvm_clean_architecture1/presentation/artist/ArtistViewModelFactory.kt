package com.example.mvvm_clean_architecture1.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_clean_architecture1.domain.usecase.GetArtistUsecase
import com.example.mvvm_clean_architecture1.domain.usecase.UpdateArtistUsecase

class ArtistViewModelFactory
    (
    private val getArtistUsecase: GetArtistUsecase,
    private val updateArtistUsecase: UpdateArtistUsecase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistUsecase, updateArtistUsecase) as T
    }
}