package com.example.mvvm_clean_architecture1.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_clean_architecture1.R
import com.example.mvvm_clean_architecture1.databinding.ActivityMovieBinding
import com.example.mvvm_clean_architecture1.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    lateinit var binding: ActivityMovieBinding

    @Inject
    lateinit var viewModelFactory: MovieViewModelFactory
    lateinit var viewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MovieActivity, R.layout.activity_movie)
        (application as Injector).createMovieSubComponent().inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MovieViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this@MovieActivity)
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = viewModel.getMovies()
        responseLiveData.observe(this, Observer {
            Log.i("MYTAG", it.toString())
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                binding.movieProgressBar.visibility = View.GONE
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
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val response = viewModel.updateMovies()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else
                binding.movieProgressBar.visibility = View.GONE
        })
    }
}
