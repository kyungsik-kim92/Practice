package com.example.marvelapipractice.network.response


import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("extension")
    val extension: String,
    @SerializedName("path")
    val path: String
) {
    fun getUrl(): String {
        return "$path.$extension"
    }
}