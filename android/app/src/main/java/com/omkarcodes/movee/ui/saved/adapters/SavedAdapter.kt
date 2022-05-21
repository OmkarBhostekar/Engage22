package com.omkarcodes.movee.ui.saved.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.omkarcodes.movee.comman.Constants.IMAGE_URL
import com.omkarcodes.movee.comman.toGenreList
import com.omkarcodes.movee.databinding.ItemSearchBinding
import com.omkarcodes.movee.models.Movie
import com.omkarcodes.movee.ui.search.models.SearchResult

class SavedAdapter(
    val listener: OnClickListener,
    val list: List<Movie>
): RecyclerView.Adapter<SavedAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemSearchBinding)
        :RecyclerView.ViewHolder(binding.root){
            @SuppressLint("SetTextI18n")
            fun bind(movie: Movie){
                binding.apply {
                    root.setOnClickListener {
                        listener.onClick(movie,binding)
                    }
                    Glide.with(root.context).load(IMAGE_URL + movie.posterUrl)
                        .into(ivPoster)
                    tvTitle.text = movie.title
                    tvType.text = "${movie.type} | ${movie.language}".toUpperCase()
                    tvGenre.text = movie.genres
                }
            }
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = list[position]
        holder.bind(movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemSearchBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    interface OnClickListener{
        fun onClick(s: Movie,binding: ItemSearchBinding)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}