package com.example.marvelapipractice.model


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("count")
    val count: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total")
    val total: Int
)