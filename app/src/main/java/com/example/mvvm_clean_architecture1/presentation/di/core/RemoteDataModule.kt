package com.example.mvvm_clean_architecture1.presentation.di.core

import com.example.mvvm_clean_architecture1.data.api.TMDBService
import com.example.mvvm_clean_architecture1.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.mvvm_clean_architecture1.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.example.mvvm_clean_architecture1.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.mvvm_clean_architecture1.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.example.mvvm_clean_architecture1.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.mvvm_clean_architecture1.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun movieRemoteDataSourceProvider(tmdbService: TMDBService) : MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun artistRemoteDataSourceProvider(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun tvShowRemoteDataSourceProvider(tmdbService: TMDBService): TvShowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }
}