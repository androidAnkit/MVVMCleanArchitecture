package com.example.mvvm_clean_architecture1.presentation.di.artist

import com.example.mvvm_clean_architecture1.domain.usecase.GetArtistUsecase
import com.example.mvvm_clean_architecture1.domain.usecase.UpdateArtistUsecase
import com.example.mvvm_clean_architecture1.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun artistViewModelFactoryProvider(
        getArtistUseCase: GetArtistUsecase,
        updateArtistUsecase: UpdateArtistUsecase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistUseCase,
            updateArtistUsecase
        )
    }
}