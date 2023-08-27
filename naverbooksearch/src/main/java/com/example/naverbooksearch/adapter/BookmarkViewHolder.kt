package com.example.naverbooksearch.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.naverbooksearch.databinding.ItemBookmarkBinding
import com.example.naverbooksearch.room.BookmarkItem

class BookmarkViewHolder(private val binding: ItemBookmarkBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(item: BookmarkItem, onDelete : (BookmarkItem) -> Unit) {
        binding.bookItem = item
        itemView.setOnClickListener {
            onDelete(item)
        }
    }
}

