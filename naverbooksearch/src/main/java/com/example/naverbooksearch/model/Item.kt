package com.example.naverbooksearch.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
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
) : Parcelable