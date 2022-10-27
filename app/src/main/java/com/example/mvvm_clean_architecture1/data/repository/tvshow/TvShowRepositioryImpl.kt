package com.example.mvvm_clean_architecture1.data.repository.tvshow

import android.util.Log
import com.example.mvvm_clean_architecture1.data.model.tvShows.TvShow
import com.example.mvvm_clean_architecture1.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.mvvm_clean_architecture1.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.mvvm_clean_architecture1.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.mvvm_clean_architecture1.domain.repository.TvShowsRepository
import java.lang.Exception

class TvShowRepositioryImpl
    (
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
            ): TvShowsRepository{
    override suspend fun getTvShows(): List<TvShow>?=
        getDataFromCache()

    override suspend fun updateTvShows(): List<TvShow>? {
        lateinit var newTvShowList: List<TvShow>
        newTvShowList = getDataFromApi()
        tvShowLocalDataSource.saveTvShowsInDB(newTvShowList)
        tvShowCacheDataSource.saveTvShowsInCache(newTvShowList)
        return newTvShowList
    }

    suspend fun getDataFromApi(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response?.body()
            if(body!=null){
                tvShowList = body.tvShows
            }else{
                Log.i("MYTAG", "No Movies from the API")
            }
        }catch (e: Exception){
            Log.i("MYTAG", "Exception from the Tvshow Api: ${e.message.toString()}")
        }
        return tvShowList
    }

    suspend fun getDataFromDB(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()!!
        }catch (e: Exception){
            Log.i("MYTAG", "Exception from the Tvshow Api: ${e.message.toString()}")
        }
        if(tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList = getDataFromApi()
            tvShowLocalDataSource.saveTvShowsInDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getDataFromCache(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()!!
        }catch (e: Exception){
            Log.i("MYTAG", "Exception from the Tvshow Api: ${e.message.toString()}")
        }
        if(tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList = getDataFromDB()
            tvShowCacheDataSource.saveTvShowsInCache(tvShowList)
        }
        return tvShowList
    }

}