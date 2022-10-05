package com.example.mvvm_clean_architecture1.presentation.tvshows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mvvm_clean_architecture1.R
import com.example.mvvm_clean_architecture1.databinding.ActivityMovieBinding
import com.example.mvvm_clean_architecture1.databinding.ActivityTvShowBinding

class TvShowActivity : AppCompatActivity() {
    lateinit var binding: ActivityTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@TvShowActivity, R.layout.activity_tv_show)
    }
}