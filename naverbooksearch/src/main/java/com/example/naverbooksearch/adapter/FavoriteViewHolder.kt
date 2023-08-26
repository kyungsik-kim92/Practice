package com.example.naverbooksearch.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.naverbooksearch.databinding.ItemBookBinding
import com.example.naverbooksearch.model.Item

class FavoriteViewHolder(private val binding: ItemBookBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(item: Item) {
        binding.bookItem = item


    }
}

