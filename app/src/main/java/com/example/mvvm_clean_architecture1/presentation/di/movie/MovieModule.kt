package com.example.mvvm_clean_architecture1.presentation.di.movie

import com.example.mvvm_clean_architecture1.domain.usecase.GetMoviesUsecase
import com.example.mvvm_clean_architecture1.domain.usecase.UpdateMoviesUsecase
import com.example.mvvm_clean_architecture1.presentation.movie.MovieViewModel
import com.example.mvvm_clean_architecture1.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun movieViewModelFactoryProvider(
        movieGetUsecase: GetMoviesUsecase,
        movieUpdateUsecase: UpdateMoviesUsecase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(movieGetUsecase, movieUpdateUsecase)
    }
}