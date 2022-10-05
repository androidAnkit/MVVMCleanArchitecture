package com.example.mvvm_clean_architecture1.domain.repository

import com.example.mvvm_clean_architecture1.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtist():List<Artist>?
    suspend fun updateArtist():List<Artist>?
}