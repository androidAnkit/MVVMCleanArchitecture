package com.example.mvvm_clean_architecture1.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_clean_architecture1.R
import com.example.mvvm_clean_architecture1.databinding.ActivityArtistBinding
import com.example.mvvm_clean_architecture1.presentation.di.Injector
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var artistViewModelFactory: ArtistViewModelFactory
    lateinit var artistViewModel: ArtistViewModel
    lateinit var adapter: ArtistAdapter
    lateinit var binding: ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@ArtistActivity, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent().inject(this)
        artistViewModel = ViewModelProvider(this, artistViewModelFactory)
            .get(ArtistViewModel::class.java)
        initRecyclerView()
    }

    fun initRecyclerView() {
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this@ArtistActivity)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter
        displayPopularActors()
    }

    fun displayPopularActors() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val response = artistViewModel.getArtist()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(this, "No Data found on device", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateActorList()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun updateActorList() {
        val update = artistViewModel.updateArtist()
        update.observe(this, Observer {
            it?.let {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } ?: run {
                binding.artistProgressBar.visibility = View.GONE
            }
/*          or
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                binding.artistProgressBar.visibility = View.GONE
            }*/
        })
    }
}