package com.example.mvvm_clean_architecture1.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.mvvm_clean_architecture1.data.db.ArtistDao
import com.example.mvvm_clean_architecture1.data.db.MovieDao
import com.example.mvvm_clean_architecture1.data.db.TMDBDatabase
import com.example.mvvm_clean_architecture1.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun movieDatabaseProvider(context: Context): TMDBDatabase {
        return Room.databaseBuilder(
            context,
            TMDBDatabase::class.java,
            "tmdbClient"
        ).build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao{
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao{
        return tmdbDatabase.tvShowDao()
    }

}