package com.example.mvvm_clean_architecture1.presentation.di.core

import com.example.mvvm_clean_architecture1.data.repository.artist.ArtistRepositoryImpl
import com.example.mvvm_clean_architecture1.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.mvvm_clean_architecture1.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.mvvm_clean_architecture1.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.mvvm_clean_architecture1.data.repository.movie.MovieRepositoryImpl
import com.example.mvvm_clean_architecture1.data.repository.movie.datasource.MovieCacheDataSource
import com.example.mvvm_clean_architecture1.data.repository.movie.datasource.MovieLocalDataSource
import com.example.mvvm_clean_architecture1.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.mvvm_clean_architecture1.data.repository.tvshow.TvShowRepositioryImpl
import com.example.mvvm_clean_architecture1.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.mvvm_clean_architecture1.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.mvvm_clean_architecture1.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.mvvm_clean_architecture1.domain.repository.ArtistRepository
import com.example.mvvm_clean_architecture1.domain.repository.MovieRepository
import com.example.mvvm_clean_architecture1.domain.repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun movieRepositoryProvider(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun artistRepositoryProvider(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun tvShowRepositoryProvider(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowsRepository {
        return TvShowRepositioryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

}