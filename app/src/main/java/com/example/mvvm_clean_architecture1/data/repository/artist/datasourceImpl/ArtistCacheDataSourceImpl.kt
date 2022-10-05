package com.example.mvvm_clean_architecture1.data.repository.artist.datasourceImpl

import com.example.mvvm_clean_architecture1.data.model.artist.Artist
import com.example.mvvm_clean_architecture1.data.model.artist.ArtistList
import com.example.mvvm_clean_architecture1.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl(): ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistFromCache(): List<Artist>? = artistList

    override suspend fun saveArtistInCache(artists: List<Artist>?) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}