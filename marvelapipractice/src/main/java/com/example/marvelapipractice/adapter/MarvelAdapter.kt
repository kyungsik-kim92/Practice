package com.example.marvelapipractice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapipractice.databinding.ItemCharacterBinding
import com.example.marvelapipractice.network.response.Result

class MarvelAdapter(private val characterItem: List<Result>) : RecyclerView.Adapter<MarvelViewHolder>() {

//    private val characterItem = mutableListOf<Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MarvelViewHolder(binding)
    }

    override fun getItemCount(): Int = characterItem.size

    override fun onBindViewHolder(holder: MarvelViewHolder, position: Int) {
        holder.bind(characterItem[position])
    }




//    @SuppressLint("NotifyDataSetChanged")
//    fun addAll(list: List<Result>) {
//        characterItem.clear()
//        characterItem.addAll(list)
//        notifyDataSetChanged()
//    }
}