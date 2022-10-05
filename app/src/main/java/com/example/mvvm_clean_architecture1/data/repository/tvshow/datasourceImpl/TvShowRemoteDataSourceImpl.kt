package com.example.mvvm_clean_architecture1.data.repository.tvshow.datasourceImpl

import com.example.mvvm_clean_architecture1.data.api.TMDBService
import com.example.mvvm_clean_architecture1.data.model.tvShows.TvShow
import com.example.mvvm_clean_architecture1.data.model.tvShows.TvShowList
import com.example.mvvm_clean_architecture1.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl
    (
    private val tmdbService: TMDBService,
    private val apiKey: String
): TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList>{
        return tmdbService.getPopularTvShows(apiKey)
    }

}