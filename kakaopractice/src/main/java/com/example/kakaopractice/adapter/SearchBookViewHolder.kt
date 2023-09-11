package com.example.kakaopractice.adapter

import android.util.SparseBooleanArray
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kakaopractice.databinding.ItemSearchBinding
import com.example.kakaopractice.network.response.KakaoBookItem
import com.google.android.material.snackbar.Snackbar

class SearchBookViewHolder(private val binding: ItemSearchBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private val statusCheckBox = SparseBooleanArray()


    fun bind(
        kakaoBookItem: KakaoBookItem,
        onItemClick: (KakaoBookItem) -> Unit,
        onBookMarkInsertClick :(KakaoBookItem) -> Unit,
        onBookMarkDeleteClick :(KakaoBookItem) -> Unit


    ) {
        binding.bookItem = kakaoBookItem
        binding.author.text = kakaoBookItem.authors.toString()

        binding.bookmark.isChecked = statusCheckBox[adapterPosition]
        binding.bookmark.setOnClickListener {

            if(!binding.bookmark.isChecked){
                onBookMarkDeleteClick(kakaoBookItem)
                statusCheckBox.put(adapterPosition,true)
                Snackbar.make(binding.root, "북마크가 해제 되었습니다.", Snackbar.LENGTH_SHORT).show()


            }
            else{
            onBookMarkInsertClick(kakaoBookItem)
                statusCheckBox.put(adapterPosition,false)
                Snackbar.make(binding.root,"북마크에 추가 되었습니다.", Snackbar.LENGTH_SHORT).show()

            }
        }
//
        itemView.setOnClickListener {
            onItemClick(kakaoBookItem)

        }

    }
}


