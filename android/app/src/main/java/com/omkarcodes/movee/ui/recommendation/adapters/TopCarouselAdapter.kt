package com.omkarcodes.movee.ui.recommendation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.omkarcodes.movee.comman.Constants.IMAGE_URL
import com.omkarcodes.movee.databinding.ItemBigPosterMovieBinding
import com.omkarcodes.movee.ui.home.models.NetflixOg
import com.omkarcodes.movee.ui.recommendation.models.RecMovie

class TopCarouselAdapter(
        private val list: List<RecMovie>,
        private val listener: OnMovieClick
) : RecyclerView.Adapter<TopCarouselAdapter.ViewHolder>() {

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
            binding.tvMovieTitle.text = list[position].title
//            binding.tvReleaseDate.text = list[position].first_air_date
            binding.root.setOnClickListener {
                listener.onCarouselClick(list[position],binding)
            }
        }
    }

    interface OnMovieClick{
        fun onCarouselClick(movie: RecMovie,binding: ItemBigPosterMovieBinding)
    }
}