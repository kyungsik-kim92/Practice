package com.example.kakaopractice.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.kakaopractice.databinding.ItemSearchBinding
import com.example.kakaopractice.network.response.KakaoBookItem
import com.google.android.material.snackbar.Snackbar

class SearchBookViewHolder(private val binding: ItemSearchBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(
        kakaoBookItem: KakaoBookItem,
        onItemClick: (KakaoBookItem) -> Unit,
        onBookMarkInsertClick :(KakaoBookItem) -> Unit,
        onBookMarkDeleteClick :(KakaoBookItem) -> Unit


    ) {
        binding.bookItem = kakaoBookItem
        binding.author.text = kakaoBookItem.authors.toString()
        binding.bookmark.setOnClickListener {

            if(binding.bookmark.isChecked){

            onBookMarkInsertClick(kakaoBookItem)
                Snackbar.make(binding.root,"북마크에 추가 되었습니다.", Snackbar.LENGTH_SHORT).show()
            }
            else{
                onBookMarkDeleteClick(kakaoBookItem)
                Snackbar.make(binding.root, "북마크가 해제 되었습니다.", Snackbar.LENGTH_SHORT).show()
            }
        }
//
        itemView.setOnClickListener {
            onItemClick(kakaoBookItem)

        }

    }
}


