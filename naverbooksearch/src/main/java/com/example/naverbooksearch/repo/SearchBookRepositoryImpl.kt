package com.example.naverbooksearch.repo

import com.example.naverbooksearch.model.Meta
import com.example.naverbooksearch.repo.SearchBookRepository
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

}
