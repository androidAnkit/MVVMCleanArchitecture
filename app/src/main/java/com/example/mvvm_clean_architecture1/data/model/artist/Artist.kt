package com.example.mvvm_clean_architecture1.data.model.artist


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_artist")
data class Artist(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("biography")
    val biography: String?,
    @SerializedName("profile_path")
    val profilePath: String?
)