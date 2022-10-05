package com.example.mvvm_clean_architecture1.data.repository.artist.datasourceImpl

import com.example.mvvm_clean_architecture1.data.api.TMDBService
import com.example.mvvm_clean_architecture1.data.model.artist.ArtistList
import com.example.mvvm_clean_architecture1.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl
    (
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList>? {
        return tmdbService.getPopularArtists(apiKey)
    }
}