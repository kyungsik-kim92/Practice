package com.example.naverbooksearch.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.naverbooksearch.databinding.ItemBookBinding
import com.example.naverbooksearch.model.Item

class SearchBookViewHolder (private val binding: ItemBookBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(item: Item) {

        Glide.with(itemView).load(item.image).into(binding.image)

        binding.title.text = item.title

        binding.author.text = "지은이: ${item.author}"

        binding.pubdate.text = item.pubdate.substring(0 until 4)
    }
}