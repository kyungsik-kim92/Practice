package com.example.kakaopractice.data.repo

import com.example.kakaopractice.network.response.KakaoBookItem
import com.example.kakaopractice.room.BookMarkItem
import com.example.kakaopractice.room.BookSearchDao

class BookMarkRepositoryImpl(private var bookSearchDao: BookSearchDao) : BookMarkRepository {
    override suspend fun insertBook(item: BookMarkItem) {
        bookSearchDao.insertBook(item)
    }

    override suspend fun deleteBook(item: BookMarkItem) {
    bookSearchDao.deleteBook(item)
    }

    override fun getFavoriteBooks(): List<BookMarkItem> {
        return bookSearchDao.getFavoriteBooks()
    }


    companion object {
        private var INSTANCE: BookMarkRepositoryImpl? = null

        fun getInstance(bookSearchDao: BookSearchDao): BookMarkRepository =
            INSTANCE ?: BookMarkRepositoryImpl(bookSearchDao).also { INSTANCE = it }
    }
}