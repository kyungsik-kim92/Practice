package com.example.kakaopractice.util

import com.example.kakaopractice.constants.KakaoConstants.BASE_URL
import com.example.kakaopractice.network.BookApiService
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