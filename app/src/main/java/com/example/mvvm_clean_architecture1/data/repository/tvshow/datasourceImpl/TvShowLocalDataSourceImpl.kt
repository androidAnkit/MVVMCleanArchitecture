package com.example.mvvm_clean_architecture1.data.repository.tvshow.datasourceImpl

import com.example.mvvm_clean_architecture1.data.db.TvShowDao
import com.example.mvvm_clean_architecture1.data.model.tvShows.TvShow
import com.example.mvvm_clean_architecture1.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao):
    TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow>? = tvShowDao.getTvShows()

    override suspend fun saveTvShowsInDB(tvShows: List<TvShow>?) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShows?.let{
                tvShowDao.saveTvShows(it)
            }
        }
    }

    override suspend fun allClear() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}