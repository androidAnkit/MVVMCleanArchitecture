package com.example.mvvm_clean_architecture1.data.model.tvShows


import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>
)