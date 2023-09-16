package com.example.marvelapipractice.util

import com.example.marvelapipractice.constants.Constants.BASE_URL
import com.example.marvelapipractice.network.MarvelService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }
    val api : MarvelService by lazy {
        retrofit.create(MarvelService::class.java)
    }

}