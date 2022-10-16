package com.example.mvvm_clean_architecture1.presentation.tvshows

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
import com.example.mvvm_clean_architecture1.R
import com.example.mvvm_clean_architecture1.databinding.ActivityTvShowBinding
import com.example.mvvm_clean_architecture1.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    lateinit var binding: ActivityTvShowBinding

    @Inject
    lateinit var tvShowViewModelFactory: TvShowViewModelFactory
    lateinit var viewModel: TvShowViewModel
    lateinit var adapter: TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@TvShowActivity, R.layout.activity_tv_show)
        (application as Injector).createTvShowSubComponent().inject(this)
        viewModel = ViewModelProvider(this, tvShowViewModelFactory)
            .get(TvShowViewModel::class.java)
        initRecylerView()
    }

    fun initRecylerView() {
        binding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this@TvShowActivity)
        adapter = TvShowAdapter()
        binding.tvShowRecyclerView.adapter = adapter
        displayPopulatTvShows()
    }

    fun displayPopulatTvShows() {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val response = viewModel.getTvShows()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            } else {
                binding.tvShowProgressBar.visibility = View.GONE
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
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun updateTvShows(){
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val update = viewModel.updateTvShow()
        update.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            }else{
                binding.tvShowProgressBar.visibility = View.GONE
            }
        })

    }

}