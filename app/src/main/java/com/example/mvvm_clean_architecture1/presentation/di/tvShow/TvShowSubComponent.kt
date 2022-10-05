package com.example.mvvm_clean_architecture1.presentation.di.tvShow

import com.example.mvvm_clean_architecture1.presentation.tvshows.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }
}