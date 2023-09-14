package com.example.marvelapipractice.api

import com.example.marvelapipractice.api.constants.Constants
import com.example.marvelapipractice.api.constants.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    }

    val api : MarvelApiService by lazy {
        retrofit.create(MarvelApiService::class.java)
    }


}