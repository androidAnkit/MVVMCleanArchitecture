package com.example.mvvm_clean_architecture1.presentation.di.core

import com.example.mvvm_clean_architecture1.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.mvvm_clean_architecture1.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.example.mvvm_clean_architecture1.data.repository.movie.datasource.MovieCacheDataSource
import com.example.mvvm_clean_architecture1.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.example.mvvm_clean_architecture1.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.mvvm_clean_architecture1.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun movieCacheDataSourceProvider() : MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun artistCacheDataSourceProvider() : ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun tvShowCacheDataSourceProvider() : TvShowCacheDataSource{
        return TvShowCacheDataSourceImpl()
    }
}