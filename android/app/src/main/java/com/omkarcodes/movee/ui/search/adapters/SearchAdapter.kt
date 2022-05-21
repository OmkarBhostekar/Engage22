package com.omkarcodes.movee.ui.search.adapters

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
import com.omkarcodes.movee.ui.search.models.SearchResult

class SearchAdapter(
    val listener: OnClickListener
): PagingDataAdapter<SearchResult, SearchAdapter.ViewHolder>(SEARCH_COMPARATOR) {

    companion object {
        val SEARCH_COMPARATOR = object : DiffUtil.ItemCallback<SearchResult>(){
            override fun areItemsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(private val binding: ItemSearchBinding)
        :RecyclerView.ViewHolder(binding.root){
            @SuppressLint("SetTextI18n")
            fun bind(search: SearchResult){
                binding.apply {
                    root.setOnClickListener {
                        listener.onClick(search,binding)
                    }
                    Glide.with(root.context).load(IMAGE_URL + search.poster_path)
                        .into(ivPoster)
                    tvTitle.text = if(search.media_type == "movie") search.title else search.name!!
                    tvType.text = "${search.media_type} | ${search.original_language}".toUpperCase()
                    tvGenre.text = search.genre_ids?.toGenreList() ?: ""
                }
            }
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { search ->
            holder.bind(search)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemSearchBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    interface OnClickListener{
        fun onClick(s: SearchResult,binding: ItemSearchBinding)
    }
}