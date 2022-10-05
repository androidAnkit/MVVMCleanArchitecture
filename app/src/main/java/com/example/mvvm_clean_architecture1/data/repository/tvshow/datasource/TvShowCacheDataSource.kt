package com.example.mvvm_clean_architecture1.data.repository.tvshow.datasource

import com.example.mvvm_clean_architecture1.data.model.tvShows.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache():List<TvShow>?
    suspend fun saveTvShowsInCache(tvShows:List<TvShow>?)
}