package com.example.naverbooksearch.data.repo

import com.example.naverbooksearch.network.response.Meta
import retrofit2.Response

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