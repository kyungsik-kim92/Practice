package com.example.naverbooksearch.data.repo

import com.example.naverbooksearch.network.response.Meta
import com.example.naverbooksearch.util.RetrofitInstance
import retrofit2.Response

class SearchBookRepositoryImpl : SearchBookRepository {

    override suspend fun searchBooks(
        id: String,
        secretKey: String,
        query: String,
        display: Int,
        start: Int,
        sort: String
    ): Response<Meta> {
        return RetrofitInstance.api.searchBooks(id, secretKey, query, display, start, sort)
    }


    companion object {
        private var INSTANCE: SearchBookRepositoryImpl? = null

        fun getInstance(): SearchBookRepository =
            INSTANCE ?: SearchBookRepositoryImpl().also { INSTANCE = it }
    }

}
