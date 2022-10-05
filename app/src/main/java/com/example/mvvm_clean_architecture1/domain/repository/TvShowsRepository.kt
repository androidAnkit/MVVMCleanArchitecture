package com.example.mvvm_clean_architecture1.domain.repository

import com.example.mvvm_clean_architecture1.data.model.tvShows.TvShow

interface TvShowsRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}