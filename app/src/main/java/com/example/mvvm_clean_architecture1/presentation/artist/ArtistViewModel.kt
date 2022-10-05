package com.example.mvvm_clean_architecture1.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvm_clean_architecture1.domain.usecase.GetArtistUsecase
import com.example.mvvm_clean_architecture1.domain.usecase.UpdateArtistUsecase

class ArtistViewModel
    (
    private val getArtistUsecase: GetArtistUsecase,
    private val updateArtistUsecase: UpdateArtistUsecase
) : ViewModel() {
    fun getArtist() = liveData {
        val artistList = getArtistUsecase.execute()
        emit(artistList)
    }

    fun updateArtist() = liveData {
        val artistList = updateArtistUsecase.execute()
        emit(artistList)
    }
}