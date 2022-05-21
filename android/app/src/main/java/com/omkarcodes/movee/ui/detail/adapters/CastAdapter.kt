package com.omkarcodes.movee.ui.detail.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.omkarcodes.movee.comman.Constants.IMAGE_URL
import com.omkarcodes.movee.databinding.ItemCastBinding
import com.omkarcodes.movee.ui.detail.models.tv.Cast

class CastAdapter(
        val list: List<Cast>
) : RecyclerView.Adapter<CastAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCastBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private val binding: ItemCastBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int){
            binding.apply {
                Glide.with(root.context).load(IMAGE_URL + list[position].profile_path).into(ivProfile)
                tvName.text = list[position].name
            }
        }
    }
}