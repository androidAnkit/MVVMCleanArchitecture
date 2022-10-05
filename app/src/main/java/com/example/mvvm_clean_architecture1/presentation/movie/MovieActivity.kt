package com.example.mvvm_clean_architecture1.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_clean_architecture1.R
import com.example.mvvm_clean_architecture1.databinding.ActivityMovieBinding
import com.example.mvvm_clean_architecture1.presentation.di.Injector

class MovieActivity : AppCompatActivity() {
    lateinit var binding: ActivityMovieBinding
    lateinit var viewModelFactory: MovieViewModelFactory
    lateinit var viewModel: MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MovieActivity, R.layout.activity_movie)
        (application as Injector).createMovieSubComponent().inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MovieViewModel::class.java)
        val responseLiveData = viewModel.getMovies()
        responseLiveData.observe(this, Observer {
            Log.i("MYTAG" , it.toString())
        })
    }
}