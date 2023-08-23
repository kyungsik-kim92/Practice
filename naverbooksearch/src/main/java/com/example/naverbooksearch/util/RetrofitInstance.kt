package com.example.naverbooksearch.util


import com.example.naverbooksearch.api.BookApiService
import com.example.naverbooksearch.constants.NaverConstants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val api: BookApiService by lazy {
        retrofit.create(BookApiService::class.java)
    }
}