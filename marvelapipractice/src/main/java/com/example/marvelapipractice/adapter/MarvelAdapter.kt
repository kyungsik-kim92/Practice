package com.example.marvelapipractice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapipractice.databinding.ItemSearchBinding
import com.example.marvelapipractice.model.Result

class MarvelAdapter : RecyclerView.Adapter<MarvelViewHolder>() {

    private val characterItem = mutableListOf<Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MarvelViewHolder(binding)
    }

    override fun getItemCount(): Int = characterItem.size

    override fun onBindViewHolder(holder: MarvelViewHolder, position: Int) {
        holder.bind(characterItem[position])
    }
}