package com.example.mvvm_clean_architecture1.presentation.di

import com.example.mvvm_clean_architecture1.presentation.di.artist.ArtistSubComponent
import com.example.mvvm_clean_architecture1.presentation.di.movie.MovieSubComponent
import com.example.mvvm_clean_architecture1.presentation.di.tvShow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createArtistSubComponent():ArtistSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
}