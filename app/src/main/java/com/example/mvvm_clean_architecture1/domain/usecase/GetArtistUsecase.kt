package com.example.mvvm_clean_architecture1.domain.usecase

import com.example.mvvm_clean_architecture1.data.model.artist.Artist
import com.example.mvvm_clean_architecture1.domain.repository.ArtistRepository

class GetArtistUsecase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.getArtist()
}