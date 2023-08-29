package com.example.kakaopractice.data.repo

import com.example.kakaopractice.network.response.BookSearchData
import com.example.kakaopractice.util.RetrofitInstance
import retrofit2.Response

class SearchBookRepositoryImpl : SearchBookRepository {
    override suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<BookSearchData> {
        return RetrofitInstance.api.searchBooks(query, sort, page, size)
    }

    companion object {
        private var INSTANCE: SearchBookRepositoryImpl? = null

        fun getInstance(): SearchBookRepository =
            INSTANCE ?: SearchBookRepositoryImpl().also { INSTANCE = it }
    }
}