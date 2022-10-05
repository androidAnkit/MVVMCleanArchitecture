package com.example.mvvm_clean_architecture1.data.repository.artist.datasource

import com.example.mvvm_clean_architecture1.data.api.TMDBService
import com.example.mvvm_clean_architecture1.data.model.artist.Artist
import com.example.mvvm_clean_architecture1.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource{
    suspend fun getArtists():Response<ArtistList>?
}