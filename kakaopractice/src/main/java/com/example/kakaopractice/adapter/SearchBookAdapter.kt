package com.example.kakaopractice.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kakaopractice.databinding.ItemSearchBinding
import com.example.kakaopractice.network.response.KakaoBookItem

class SearchBookAdapter(
    val onItemClick: (KakaoBookItem) -> Unit,
    val onBookMarkInsertClick: (KakaoBookItem) -> Unit,
    val onBookMarkDeleteClick: (KakaoBookItem) -> Unit,

    ) : RecyclerView.Adapter<SearchBookViewHolder>() {

    private val kakaoBookList = mutableListOf<KakaoBookItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchBookViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchBookViewHolder(binding)
    }

    override fun getItemCount(): Int = kakaoBookList.size

    override fun onBindViewHolder(holder: SearchBookViewHolder, position: Int) {
        holder.bind(
            kakaoBookList[position],
            onItemClick,
            onBookMarkInsertClick,
            onBookMarkDeleteClick
        )
    }


    @SuppressLint("NotifyDataSetChanged")
    fun addAll(list: List<KakaoBookItem>) {
        kakaoBookList.clear()
        kakaoBookList.addAll(list)
        notifyDataSetChanged()
    }

    fun addBookmark(item: KakaoBookItem) {
        if (kakaoBookList.contains(item)) {
            val position = kakaoBookList.indexOf(item)
            kakaoBookList[position].isBookmark = true
            notifyItemChanged(position)
        }
    }

    fun deleteBookmark(item: KakaoBookItem) {
        if (kakaoBookList.contains(item)) {
            val position = kakaoBookList.indexOf(item)
            kakaoBookList[position].isBookmark = false
            notifyItemChanged(position)
        }
    }

}