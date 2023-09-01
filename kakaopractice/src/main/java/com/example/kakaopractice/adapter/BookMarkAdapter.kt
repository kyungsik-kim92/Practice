package com.example.kakaopractice.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kakaopractice.databinding.ItemBookmarkBinding
import com.example.kakaopractice.databinding.ItemSearchBinding
import com.example.kakaopractice.room.BookMarkItem

class BookMarkAdapter() :
    RecyclerView.Adapter<BookMarkViewHolder>() {

    private val bookMarkItem = mutableListOf<BookMarkItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookMarkViewHolder{
        val binding = ItemBookmarkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookMarkViewHolder(binding)
    }

    override fun getItemCount(): Int = bookMarkItem.size


    override fun onBindViewHolder(holder: BookMarkViewHolder, position: Int) {
        holder.bind(bookMarkItem[position])
    }


    @SuppressLint("NotifyDataSetChanged")
    fun addAll(list: List<BookMarkItem>) {
        bookMarkItem.clear()
        bookMarkItem.addAll(list)
        notifyDataSetChanged()
    }
}