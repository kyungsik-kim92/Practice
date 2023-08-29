package com.example.kakaopractice.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingAdapter {

    @BindingAdapter("imageUrl")
    fun loadImage(view : ImageView, url : String){

        Glide.with(view.context).load(url).into(view)


    }
}