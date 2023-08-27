package com.example.naverbooksearch.network.response
import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("display")
    val display: Int,
    @SerializedName("items")
    val naverBookItems: List<NaverBookItem>,
    @SerializedName("lastBuildDate")
    val lastBuildDate: String,
    @SerializedName("start")
    val start: Int,
    @SerializedName("total")
    val total: Int
)