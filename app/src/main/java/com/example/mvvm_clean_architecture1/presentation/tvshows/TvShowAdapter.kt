package com.example.mvvm_clean_architecture1.presentation.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm_clean_architecture1.R
import com.example.mvvm_clean_architecture1.data.model.tvShows.TvShow
import com.example.mvvm_clean_architecture1.databinding.ListItemBinding

class TvShowAdapter : RecyclerView.Adapter<TvShowViewHolder>() {
    private val tvShowList = ArrayList<TvShow>()

    fun setList(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil
            .inflate(
                inflater,
                R.layout.list_item,
                parent,
                false
            )
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }
}

class TvShowViewHolder(val binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(tvShow: TvShow) {
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        val posterUrl = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
    }
}