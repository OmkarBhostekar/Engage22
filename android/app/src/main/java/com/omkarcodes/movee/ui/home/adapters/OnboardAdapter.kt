package com.omkarcodes.movee.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.omkarcodes.movee.R
import com.omkarcodes.movee.comman.Constants.IMAGE_URL
import com.omkarcodes.movee.databinding.ItemBigPosterMovieBinding
import com.omkarcodes.movee.databinding.ItemOnboardingBinding
import com.omkarcodes.movee.ui.home.models.NetflixOg

class OnboardAdapter() : RecyclerView.Adapter<OnboardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return 3
    }

    inner class ViewHolder(private val binding: ItemOnboardingBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int){
            binding.apply {
                lotteView.apply {
                    setAnimation(when(position){
                        0 -> R.raw.movie_info
                        1 -> R.raw.movie_recom
                        else -> R.raw.watch_trailer
                    })
                    playAnimation()
                }
                textView.text = when(position){
                    0 -> "Get personalised movies recommendations. Decide which movie to watch next in you free time."
                    1 -> "Get detailed info of movies and TV shows. Search for movies and more..."
                    else -> "What's better than playing movie trailers in the app itself. Now watch trailers in the app."
                }
            }
        }
    }
}