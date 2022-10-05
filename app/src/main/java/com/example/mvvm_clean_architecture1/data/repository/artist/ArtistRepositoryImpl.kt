package com.example.mvvm_clean_architecture1.data.repository.artist

import android.util.Log
import com.example.mvvm_clean_architecture1.data.model.artist.Artist
import com.example.mvvm_clean_architecture1.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.mvvm_clean_architecture1.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.mvvm_clean_architecture1.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.mvvm_clean_architecture1.domain.repository.ArtistRepository

class ArtistRepositoryImpl
    (
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtist(): List<Artist>? = getDataFromCache()

    override suspend fun updateArtist(): List<Artist>? {
        lateinit var newArtistList: List<Artist>
        newArtistList = getDataFromApi()
        artistLocalDataSource.saveArtistInDB(newArtistList)
        artistCacheDataSource.saveArtistInCache(newArtistList)
        return newArtistList
    }

    suspend fun getDataFromApi(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response?.body()
            body?.let {
                artistList = it.artists
            }
        } catch (e: Exception) {
            Log.i("MYTAG", "The exception from Api artist is: ${e.message.toString()}")
        }
        return artistList
    }

    suspend fun getDataFromDB(): List<Artist>{
        lateinit var artistList: List<Artist>
        try{
            artistList = artistLocalDataSource.getArtistFromDB()!!
        }catch (e:Exception){
            Log.i("MYTAG", "The exception from DB artist is: ${e.message.toString()}")
        }
        if(artistList.size>0){
            return artistList
        }else{
            artistList = getDataFromApi()
            artistLocalDataSource.saveArtistInDB(artistList)
        }
        return artistList
    }

    suspend fun getDataFromCache(): List<Artist>{
        lateinit var artistList: List<Artist>
        try{
            artistList = artistCacheDataSource.getArtistFromCache()!!
        }catch (e:Exception){
            Log.i("MYTAG", "The exception from cache artist is: ${e.message.toString()}")
        }
        if(artistList.size>0){
            return artistList
        }else{
            artistList = getDataFromDB()
            artistCacheDataSource.saveArtistInCache(artistList)
        }
        return artistList
    }
}