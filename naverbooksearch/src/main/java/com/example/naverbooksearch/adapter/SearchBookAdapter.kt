package com.example.naverbooksearch.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.naverbooksearch.databinding.ItemBookBinding
import com.example.naverbooksearch.model.Item

class SearchBookAdapter : RecyclerView.Adapter<SearchBookViewHolder>() {

    private val items = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchBookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchBookViewHolder(binding)

    }

    override fun getItemCount(): Int = items.size


    private var onItemClickListener: ((Item) -> Unit)? = null
    fun setOnItemClickListener(listener: (Item) -> Unit) {
        onItemClickListener = listener

    }

    override fun onBindViewHolder(holder: SearchBookViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(items[position]) }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(list: List<Item>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }


}