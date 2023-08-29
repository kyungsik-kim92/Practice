package com.example.kakaopractice.data.repo

import com.example.kakaopractice.network.response.BookSearchData
import retrofit2.Response

interface SearchBookRepository {

    suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int,
    ): Response<BookSearchData>
}