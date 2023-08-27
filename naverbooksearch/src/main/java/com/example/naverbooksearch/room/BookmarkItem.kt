package com.example.naverbooksearch.room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "book")
data class BookmarkItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val author: String,
    val description: String,
    val discount: String,
    val image: String,
    val isbn: String,
    val link: String,
    val pubdate: String,
    val publisher: String,
    val title: String
) : Parcelable {

    fun toTextAuthor(): String {
        return "지은이: $author"

    }

    fun pubYear(): String {
        return pubdate.substring(0 until 4)
    }
}