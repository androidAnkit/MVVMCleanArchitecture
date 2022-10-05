package com.example.mvvm_clean_architecture1.presentation.di.core

import com.example.mvvm_clean_architecture1.data.repository.movie.MovieRepositoryImpl
import com.example.mvvm_clean_architecture1.domain.repository.ArtistRepository
import com.example.mvvm_clean_architecture1.domain.repository.MovieRepository
import com.example.mvvm_clean_architecture1.domain.repository.TvShowsRepository
import com.example.mvvm_clean_architecture1.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun getMovieUseCaseProvider(movieRepository: MovieRepository): GetMoviesUsecase {
        return GetMoviesUsecase(movieRepository)
    }

    @Provides
    fun updateMovieUseCaseProvider(movieRepository: MovieRepository): UpdateMoviesUsecase {
        return UpdateMoviesUsecase(movieRepository)
    }

    @Provides
    fun getArtistUseCaseProvider(artistRepository: ArtistRepository): GetArtistUsecase{
        return GetArtistUsecase(artistRepository)
    }

    @Provides
    fun updateArtistUseCaseProvider(artistRepository: ArtistRepository): UpdateArtistUsecase{
        return UpdateArtistUsecase(artistRepository)
    }

    @Provides
    fun getTvShowUseCaseProvider(tvShowsRepository: TvShowsRepository): GetTvShowsUsecase{
        return GetTvShowsUsecase(tvShowsRepository)
    }

    @Provides
    fun updateTvShowUseCaseProvider(tvShowsRepository: TvShowsRepository): UpdateTvShowsUsecase{
        return UpdateTvShowsUsecase(tvShowsRepository)
    }

}