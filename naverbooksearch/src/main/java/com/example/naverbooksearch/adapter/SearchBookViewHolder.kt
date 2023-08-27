package com.example.naverbooksearch.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.naverbooksearch.databinding.ItemSearchBinding
import com.example.naverbooksearch.network.response.NaverBookItem

class SearchBookViewHolder (private val binding: ItemSearchBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(naverBookItem: NaverBookItem, onItemClick :(NaverBookItem) -> Unit) {
        binding.bookItem = naverBookItem

        itemView.setOnClickListener {
            onItemClick(naverBookItem)
        }
    }
}