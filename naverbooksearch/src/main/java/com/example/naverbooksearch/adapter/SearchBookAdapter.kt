package com.example.naverbooksearch.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.naverbooksearch.databinding.ItemSearchBinding
import com.example.naverbooksearch.network.response.NaverBookItem

class SearchBookAdapter(val onItemClick: (NaverBookItem) -> Unit) :
    RecyclerView.Adapter<SearchBookViewHolder>() {

    private val naverBookItems = mutableListOf<NaverBookItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchBookViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchBookViewHolder(binding)

    }

    override fun getItemCount(): Int = naverBookItems.size


    override fun onBindViewHolder(holder: SearchBookViewHolder, position: Int) {
        holder.bind(naverBookItems[position], onItemClick)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(list: List<NaverBookItem>) {
        naverBookItems.clear()
        naverBookItems.addAll(list)
        notifyDataSetChanged()
    }


}