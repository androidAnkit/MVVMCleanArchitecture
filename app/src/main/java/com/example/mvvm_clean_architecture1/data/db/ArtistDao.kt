package com.example.mvvm_clean_architecture1.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm_clean_architecture1.data.model.artist.Artist
import com.example.mvvm_clean_architecture1.data.model.movie.Movie

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artists: List<Artist>)

    @Query("Delete from popular_artist")
    suspend fun deleteAllArtists()

    @Query("Select * from popular_artist")
    suspend fun getArtists():List<Artist>

}