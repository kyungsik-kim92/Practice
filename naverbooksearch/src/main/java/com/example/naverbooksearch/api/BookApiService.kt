package com.example.naverbooksearch.api

import com.example.naverbooksearch.model.Meta
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface BookApiService {

    @GET("/v1/search/book_json")
    suspend fun searchBooks(
        @Header("X-Naver-Client-Id") id: String,
        @Header("X-Naver-Client-Secret") secretKey: String,
        @Query("query") query: String,
        @Query("display") display: Int,
        @Query("start") start: Int,
        @Query("sort") sort: String
    ): Response<Meta>
}