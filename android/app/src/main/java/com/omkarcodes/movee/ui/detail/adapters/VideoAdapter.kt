package com.omkarcodes.movee.ui.detail.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.omkarcodes.movee.comman.Constants.IMAGE_URL
import com.omkarcodes.movee.databinding.ItemCastBinding
import com.omkarcodes.movee.databinding.ItemVideoBinding
import com.omkarcodes.movee.ui.detail.models.tv.Cast
import com.omkarcodes.movee.ui.detail.models.video.Result

class VideoAdapter(
        val list: List<Result>,
        val listener: OnClickListener
) : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemVideoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private val binding: ItemVideoBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int){
            binding.apply {
                Glide.with(root.context)
                    .load("https://img.youtube.com/vi/${list[position].key}/0.jpg")
                    .into(ivThumbnail)
                tvTitle.text = list[position].name
                root.setOnClickListener {
                    list[position].key?.let { it1 -> listener.onClick(it1) }
                }
            }
        }
    }

    interface OnClickListener {
        fun onClick(id: String)
    }
}