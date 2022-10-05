package com.example.mvvm_clean_architecture1.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mvvm_clean_architecture1.R
import com.example.mvvm_clean_architecture1.data.model.tvShows.TvShow
import com.example.mvvm_clean_architecture1.databinding.ActivityHomeBinding
import com.example.mvvm_clean_architecture1.presentation.artist.ArtistActivity
import com.example.mvvm_clean_architecture1.presentation.movie.MovieActivity
import com.example.mvvm_clean_architecture1.presentation.tvshows.TvShowActivity

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@HomeActivity, R.layout.activity_home)

        binding.movieButton.setOnClickListener {
            val movieIntent = Intent(this@HomeActivity, MovieActivity::class.java)
            startActivity(movieIntent)
        }

        binding.artistsButton.setOnClickListener {
            val artistIntent = Intent(this@HomeActivity, ArtistActivity::class.java)
            startActivity(artistIntent)
        }

        binding.tvButton.setOnClickListener {
            val tvShowIntent = Intent(this@HomeActivity, TvShowActivity::class.java)
            startActivity(tvShowIntent)
        }
    }
}