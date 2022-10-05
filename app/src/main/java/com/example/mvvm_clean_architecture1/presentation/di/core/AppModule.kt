package com.example.mvvm_clean_architecture1.presentation.di.core

import android.content.Context
import com.example.mvvm_clean_architecture1.presentation.di.artist.ArtistSubComponent
import com.example.mvvm_clean_architecture1.presentation.di.movie.MovieSubComponent
import com.example.mvvm_clean_architecture1.presentation.di.tvShow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    subcomponents = [ArtistSubComponent::class,
        MovieSubComponent::class, TvShowSubComponent::class]
)
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun applicationContextProvider(): Context {
        return context.applicationContext
    }

}