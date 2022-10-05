package com.example.mvvm_clean_architecture1.data.model.movie


import com.example.mvvm_clean_architecture1.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)