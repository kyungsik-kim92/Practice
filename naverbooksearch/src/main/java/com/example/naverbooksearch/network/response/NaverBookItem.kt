package com.example.naverbooksearch.network.response

import android.os.Parcelable
import androidx.room.Entity
import com.example.naverbooksearch.room.BookmarkItem
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class NaverBookItem(
    @SerializedName("author")
    val author: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("discount")
    val discount: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("isbn")
    val isbn: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("pubdate")
    val pubdate: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("title")
    val title: String
) : Parcelable {

    fun toTextAuthor(): String {
        return "지은이: $author"

    }

    fun pubYear(): String {
        return pubdate.substring(0 until 4)
    }

    fun toBookmarkItem() = BookmarkItem(
        author = author,
        description = description,
        discount = discount,
        image = image,
        isbn = isbn,
        link = link,
        pubdate = pubdate,
        publisher = publisher,
        title = title
    )
}