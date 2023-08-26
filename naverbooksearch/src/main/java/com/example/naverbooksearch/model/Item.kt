package com.example.naverbooksearch.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "book")
data class Item(
    @SerializedName("id")
    @PrimaryKey
    val id : Int ,
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
) : Parcelable{

    fun toTextAuthor(): String{
        return "지은이: $author"

    }


    fun pubYear() : String{
        return pubdate.substring(0 until 4)
    }

}