package com.example.naverbooksearch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.naverbooksearch.databinding.ItemBookBinding
import com.example.naverbooksearch.model.Item

class FavoriteAdapter: RecyclerView.Adapter<FavoriteViewHolder>() {

    private val items = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)

    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size



    fun addAll(list : List<Item>){
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

}