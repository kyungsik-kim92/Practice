package com.example.kakaopractice.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.kakaopractice.databinding.ItemSearchBinding
import com.example.kakaopractice.network.response.KakaoBookItem

class SearchBookViewHolder(private val binding: ItemSearchBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(kakaoBookItem: KakaoBookItem,onItemClick:(KakaoBookItem) -> Unit,onBookMarkClick : (KakaoBookItem)-> Unit) {
        binding.bookItem = kakaoBookItem
        binding.author.text = kakaoBookItem.authors.toString()
        binding.bookmark.setOnClickListener {
            onBookMarkClick(kakaoBookItem)
        }

        itemView.setOnClickListener {
            onItemClick(kakaoBookItem)

        }
    }
}