package com.example.mvvm_clean_architecture1.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm_clean_architecture1.data.model.artist.Artist
import com.example.mvvm_clean_architecture1.data.model.movie.Movie
import com.example.mvvm_clean_architecture1.data.model.tvShows.TvShow

@Database(entities = [Movie::class,TvShow::class, Artist::class],
version = 1,
exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}