package com.omkarcodes.movee.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.omkarcodes.movee.comman.Constants.IMAGE_URL
import com.omkarcodes.movee.databinding.ItemBigPosterMovieBinding
import com.omkarcodes.movee.databinding.ItemMovieBinding
import com.omkarcodes.movee.ui.home.models.NetflixOg

class BigPosterMoviesAdapter(
        private val list: List<NetflixOg>,
        private val listener: OnMovieClick
) : RecyclerView.Adapter<BigPosterMoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBigPosterMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private val binding: ItemBigPosterMovieBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int){
            Glide.with(binding.root.context).load(IMAGE_URL+list[position].poster_path)
                    .into(binding.ivPoster)
            binding.tvMovieTitle.text = list[position].name
            binding.tvReleaseDate.text = list[position].first_air_date
            binding.root.setOnClickListener {
                listener.onBigPosterClick(list[position],binding)
            }
        }
    }

    interface OnMovieClick{
        fun onBigPosterClick(movie: NetflixOg,binding: ItemBigPosterMovieBinding)
    }
}