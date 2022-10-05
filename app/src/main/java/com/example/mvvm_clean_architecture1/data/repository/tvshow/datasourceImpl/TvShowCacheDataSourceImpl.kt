package com.example.mvvm_clean_architecture1.data.repository.tvshow.datasourceImpl

import com.example.mvvm_clean_architecture1.data.model.tvShows.TvShow
import com.example.mvvm_clean_architecture1.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl:TvShowCacheDataSource {
    private var tvShowList= ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> = tvShowList

    override suspend fun saveTvShowsInCache(tvShows: List<TvShow>?) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}