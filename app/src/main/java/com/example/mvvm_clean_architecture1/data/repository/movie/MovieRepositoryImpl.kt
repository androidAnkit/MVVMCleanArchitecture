package com.example.mvvm_clean_architecture1.data.repository.movie

import android.util.Log
import com.example.mvvm_clean_architecture1.data.model.movie.Movie
import com.example.mvvm_clean_architecture1.data.repository.movie.datasource.MovieCacheDataSource
import com.example.mvvm_clean_architecture1.data.repository.movie.datasource.MovieLocalDataSource
import com.example.mvvm_clean_architecture1.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.mvvm_clean_architecture1.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl
    (
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response?.body()
            if (body != null) {
                movieList = body.movies
            }else{
                Log.i("MYTAG", "No Movies from the API")
            }
        } catch (exception: Exception) {
            Log.i("MYTAG", "The exception from API is: ${exception.message.toString()}")
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()!!
        } catch (exception: Exception) {
            Log.i("MYTAG", "The exception from DB is: " + exception.message.toString())
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()!!
        } catch (e: Exception) {
            Log.i("MYTAG", "Exception from cache is: ${e.message.toString()}")
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }

}