package com.example.mvvm_clean_architecture1.data.repository.tvshow.datasource

import com.example.mvvm_clean_architecture1.data.model.tvShows.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>?
    suspend fun saveTvShowsInDB(tvShows: List<TvShow>?)
    suspend fun allClear()
}