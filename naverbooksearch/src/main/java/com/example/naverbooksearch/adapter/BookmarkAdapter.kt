package com.example.naverbooksearch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.naverbooksearch.databinding.ItemBookmarkBinding
import com.example.naverbooksearch.room.BookmarkItem

class BookmarkAdapter(val onDelete : (BookmarkItem) -> Unit): RecyclerView.Adapter<BookmarkViewHolder>() {

    private val naverBookItems = mutableListOf<BookmarkItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        val binding = ItemBookmarkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookmarkViewHolder(binding)

    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        holder.bind(naverBookItems[position],onDelete)
    }

    override fun getItemCount(): Int = naverBookItems.size



    fun addAll(list : List<BookmarkItem>){
        naverBookItems.clear()
        naverBookItems.addAll(list)
        notifyDataSetChanged()
    }

}