package com.example.marvelapipractice.ui.adapter

import android.util.Log
import androidx.core.view.drawToBitmap
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.marvelapipractice.databinding.ItemCharacterBinding
import com.example.marvelapipractice.network.response.Result
import com.example.marvelapipractice.util.MediaUtil.Companion.saveToGallery

class MarvelViewHolder(private val binding: ItemCharacterBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(item: Result) {
        binding.result = item
    }
}