package com.example.naverbooksearch.data.repo

import com.example.naverbooksearch.model.Meta
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Query

interface SearchBookRepository {

    suspend fun searchBooks(
        id: String,
        secretKey: String,
        query: String,
        display: Int,
        start: Int,
        sort: String
    ) : Response<Meta>


}