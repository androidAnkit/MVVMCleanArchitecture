package com.example.mvvm_clean_architecture1.data.repository.movie.datasourceImpl

import com.example.mvvm_clean_architecture1.data.model.movie.Movie
import com.example.mvvm_clean_architecture1.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> =
        movieList

    override suspend fun saveMoviesToCache(movies: List<Movie>?) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}