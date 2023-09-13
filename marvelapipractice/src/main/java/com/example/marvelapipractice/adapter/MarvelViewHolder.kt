package com.example.marvelapipractice.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapipractice.databinding.ItemSearchBinding
import com.example.marvelapipractice.model.Result

class MarvelViewHolder(private val binding : ItemSearchBinding) : RecyclerView.ViewHolder(binding.root) {


    fun bind(item : Result){
        binding.tvName.text = item.name
        binding.tvDescription.text = item.description



    }



}