package com.example.marvelapipractice.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("setUrlImg")
fun ImageView.setUrlImg(url : String?) {
    Glide.with(context)
        .load(url)
        .apply(RequestOptions.bitmapTransform(RoundedCorners(15)))
        .into(this)


}


@BindingAdapter("onScrolledBottomLine")
fun RecyclerView.onScrolledBottomLine(f : Function1<Boolean, Unit>?) {
    this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            f?.invoke(!recyclerView.canScrollVertically(1))
        }
    })
}
