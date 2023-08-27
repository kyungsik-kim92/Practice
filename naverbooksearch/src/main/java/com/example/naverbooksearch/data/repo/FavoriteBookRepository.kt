package com.example.naverbooksearch.data.repo

import androidx.lifecycle.LiveData
import com.example.naverbooksearch.network.response.NaverBookItem
import com.example.naverbooksearch.room.BookmarkItem

interface FavoriteBookRepository {


    // Room
    suspend fun insertBook(item: BookmarkItem)
    suspend fun deleteBook(item: BookmarkItem)
    fun getFavoriteBooks() : List<BookmarkItem>
}