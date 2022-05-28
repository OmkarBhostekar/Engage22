package com.omkarcodes.movee.ui.home.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.omkarcodes.movee.R
import com.omkarcodes.movee.comman.Constants
import com.omkarcodes.movee.databinding.ItemGenreBinding
import com.omkarcodes.movee.databinding.ItemMovieBinding
import com.omkarcodes.movee.ui.home.models.Genre
import com.omkarcodes.movee.ui.home.models.PopularMovie

class GenreAdapter(
    private val list: List<Genre>,
    private val listener: OnGenreClick,
) : RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    private var count = 0;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemGenreBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private val binding: ItemGenreBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int){
            binding.apply {
                textView.text = list[position].title
                if (list[position].isSelected){
                    cardView.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.colorPrimary))
                    textView.setTextColor(Color.WHITE)
                }else{
                    cardView.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.cardColor))
                    textView.setTextColor(ContextCompat.getColor(root.context, R.color.headlineColor))
                }
                cardView.setOnClickListener {
                    if (list[position].isSelected){
                        count--
                        list[position].isSelected = false
                        notifyItemChanged(position)
                        listener.onUnselect(list[position])
                    }else{
                        if (count < 3){
                            count++
                            list[position].isSelected = true
                            notifyItemChanged(position)
                            listener.onSelect(list[position])
                        }
                    }
                }
            }
        }
    }

    interface OnGenreClick{
        fun onSelect(genre: Genre)
        fun onUnselect(genre: Genre)
    }
}