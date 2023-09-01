package com.example.kakaopractice.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kakaopractice.databinding.ItemSearchBinding
import com.example.kakaopractice.network.response.KakaoBookItem
import com.example.kakaopractice.util.BookMarkDeleteClick

class SearchBookAdapter(
    val onItemClick: (KakaoBookItem) -> Unit,
    val onBookMarkInsertClick: (KakaoBookItem) -> Unit,
    val onBookMarkDeleteClick: (KakaoBookItem) -> Unit,

    ) : RecyclerView.Adapter<SearchBookViewHolder>() {

    private val kakaoBookItem = mutableListOf<KakaoBookItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchBookViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchBookViewHolder(binding)
    }

    override fun getItemCount(): Int = kakaoBookItem.size

    override fun onBindViewHolder(holder: SearchBookViewHolder, position: Int) {
        holder.bind(kakaoBookItem[position], onItemClick, onBookMarkInsertClick,onBookMarkDeleteClick)
    }



    @SuppressLint("NotifyDataSetChanged")
    fun addAll(list: List<KakaoBookItem>) {
        kakaoBookItem.clear()
        kakaoBookItem.addAll(list)
        notifyDataSetChanged()
    }
}