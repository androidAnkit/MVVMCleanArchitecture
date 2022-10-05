package com.example.mvvm_clean_architecture1.presentation.di.core

import com.example.mvvm_clean_architecture1.data.db.ArtistDao
import com.example.mvvm_clean_architecture1.data.db.MovieDao
import com.example.mvvm_clean_architecture1.data.db.TvShowDao
import com.example.mvvm_clean_architecture1.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.mvvm_clean_architecture1.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.example.mvvm_clean_architecture1.data.repository.movie.datasource.MovieLocalDataSource
import com.example.mvvm_clean_architecture1.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.example.mvvm_clean_architecture1.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.mvvm_clean_architecture1.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule() {

    @Singleton
    @Provides
    fun movieLocalDataSourceProvider(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun artistLocalDataSourceProvider(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun tvShowLocalSourceProvider(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
}