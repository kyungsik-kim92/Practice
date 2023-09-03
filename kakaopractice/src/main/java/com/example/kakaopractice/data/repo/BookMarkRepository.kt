package com.example.kakaopractice.data.repo

import com.example.kakaopractice.network.response.KakaoBookItem
import com.example.kakaopractice.room.BookMarkItem

interface BookMarkRepository {

    suspend fun insertBook(item: BookMarkItem) : Long
    suspend fun deleteBook(item: BookMarkItem) : Int
    fun getFavoriteBooks() : List<BookMarkItem>
}