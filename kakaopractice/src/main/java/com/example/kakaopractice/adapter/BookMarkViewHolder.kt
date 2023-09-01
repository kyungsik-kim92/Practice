package com.example.kakaopractice.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.kakaopractice.databinding.ItemBookmarkBinding
import com.example.kakaopractice.room.BookMarkItem

class BookMarkViewHolder(private val binding: ItemBookmarkBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(item: BookMarkItem) {
        binding.bookItem = item
        binding.author.text = item.authors.toString()
//        itemView.setOnClickListener {
//            onDelete(item)
//        }
    }
}