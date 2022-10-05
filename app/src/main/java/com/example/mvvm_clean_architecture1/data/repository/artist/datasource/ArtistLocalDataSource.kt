package com.example.mvvm_clean_architecture1.data.repository.artist.datasource

import com.example.mvvm_clean_architecture1.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB(): List<Artist>?
    suspend fun saveArtistInDB(artists: List<Artist>?)
    suspend fun allClear()
}