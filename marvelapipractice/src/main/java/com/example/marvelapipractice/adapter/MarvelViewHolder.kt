package com.example.marvelapipractice.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelapipractice.databinding.ItemCharacterBinding
import com.example.marvelapipractice.network.response.Result

class MarvelViewHolder(private val binding : ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {


    fun bind(item : Result){

        val uri = item.thumbnail.path+"."+item.thumbnail.extension

        Glide.with(itemView).load(uri).into(binding.image)
        binding.tvName.text = item.name
        binding.tvDescription.text = item.description
    }



}