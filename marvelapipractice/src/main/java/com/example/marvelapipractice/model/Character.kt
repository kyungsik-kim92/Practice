package com.example.marvelapipractice.model


import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("attributionHTML")
    val attributionHTML: String,
    @SerializedName("attributionText")
    val attributionText: String,
    @SerializedName("code")
    val code: Int,
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("data")
    val `data`: DataX,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("status")
    val status: String
)