package com.example.mvvm_clean_architecture1.data.repository.artist.datasource

import com.example.mvvm_clean_architecture1.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache():List<Artist>?
    suspend fun saveArtistInCache(artists: List<Artist>?)
}