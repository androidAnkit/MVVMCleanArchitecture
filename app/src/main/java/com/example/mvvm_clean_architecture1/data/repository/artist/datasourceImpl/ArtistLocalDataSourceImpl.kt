package com.example.mvvm_clean_architecture1.data.repository.artist.datasourceImpl

import com.example.mvvm_clean_architecture1.data.db.ArtistDao
import com.example.mvvm_clean_architecture1.data.model.artist.Artist
import com.example.mvvm_clean_architecture1.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(
    private val artistDao: ArtistDao
):ArtistLocalDataSource {
    override suspend fun getArtistFromDB(): List<Artist>? = artistDao.getArtists()

    override suspend fun saveArtistInDB(artists: List<Artist>?) {
        CoroutineScope(Dispatchers.IO).launch {
            artists?.let { artistDao.saveArtist(it) }
        }
    }

    override suspend fun allClear() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}