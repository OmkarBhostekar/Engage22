package com.omkarcodes.movee.ui.detail.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.omkarcodes.movee.comman.Constants.IMAGE_URL
import com.omkarcodes.movee.databinding.ItemMovieBinding
import com.omkarcodes.movee.ui.home.models.PopularMovie
import com.omkarcodes.movee.ui.recommendation.models.RecMovie

class MyRecomAdapter(
    private val list: List<RecMovie>,
    private val listener: OnMovieClick,
    private val type: String
) : RecyclerView.Adapter<MyRecomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private val binding: ItemMovieBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int){
            Glide.with(binding.root.context).load(IMAGE_URL + list[position].poster_path)
                    .into(binding.ivPoster)
            binding.tvMovieTitle.text = list[position].title
            binding.root.setOnClickListener {
                listener.onMyRecomClick(list[position],type,binding)
            }
        }
    }

    interface OnMovieClick{
        fun onMyRecomClick(movie: RecMovie,type: String,binding: ItemMovieBinding)
    }
}