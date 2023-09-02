package com.example.kakaopractice.data.repo

import com.example.kakaopractice.network.BookApiService
import com.example.kakaopractice.network.response.BookSearchData
import retrofit2.Response
import javax.inject.Inject

class SearchBookRepositoryImpl @Inject constructor(private val bookApiService: BookApiService) : SearchBookRepository {
    override suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<BookSearchData> {
        return bookApiService.searchBooks(query, sort, page, size)
    }


}