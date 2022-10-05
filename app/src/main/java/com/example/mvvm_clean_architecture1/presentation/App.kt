package com.example.mvvm_clean_architecture1.presentation

import android.app.Application
import com.example.mvvm_clean_architecture1.BuildConfig
import com.example.mvvm_clean_architecture1.presentation.di.Injector
import com.example.mvvm_clean_architecture1.presentation.di.artist.ArtistSubComponent
import com.example.mvvm_clean_architecture1.presentation.di.core.*
import com.example.mvvm_clean_architecture1.presentation.di.movie.MovieSubComponent
import com.example.mvvm_clean_architecture1.presentation.di.tvShow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }
}