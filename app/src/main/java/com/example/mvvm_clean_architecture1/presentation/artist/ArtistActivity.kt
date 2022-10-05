package com.example.mvvm_clean_architecture1.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mvvm_clean_architecture1.R
import com.example.mvvm_clean_architecture1.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {
    lateinit var binding: ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@ArtistActivity, R.layout.activity_artist)
    }
}