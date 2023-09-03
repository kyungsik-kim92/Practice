package com.example.kakaopractice.adapter

import android.util.Log
import android.util.SparseBooleanArray
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kakaopractice.databinding.ItemSearchBinding
import com.example.kakaopractice.network.response.KakaoBookItem
import com.google.android.material.snackbar.Snackbar

class SearchBookViewHolder(private val binding: ItemSearchBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        kakaoBookItem: KakaoBookItem,
        onItemClick: (KakaoBookItem) -> Unit,
        onBookMarkInsertClick: (KakaoBookItem) -> Unit,
        onBookMarkDeleteClick: (KakaoBookItem) -> Unit
    ) {
        binding.bookItem = kakaoBookItem
        binding.author.text = kakaoBookItem.authors.toString()

        binding.bookmark.isChecked = kakaoBookItem.isBookmark

        binding.bookmark.setOnClickListener {
            if (!binding.bookmark.isChecked) {
                onBookMarkDeleteClick(kakaoBookItem)
            } else {
                onBookMarkInsertClick(kakaoBookItem)
            }
        }

        itemView.setOnClickListener {
            onItemClick(kakaoBookItem)
        }

    }
}


