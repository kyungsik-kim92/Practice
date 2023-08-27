package com.example.naverbooksearch.data.repo

import com.example.naverbooksearch.room.BookSearchDao
import com.example.naverbooksearch.room.BookmarkItem

class FavoriteBookRepositoryImpl(private var bookSearchDao: BookSearchDao) :
    FavoriteBookRepository {


    override suspend fun insertBook(item: BookmarkItem) {
        bookSearchDao.insertBook(item)
    }

    override suspend fun deleteBook(item: BookmarkItem) {
        bookSearchDao.deleteBook(item)
    }


    override fun getFavoriteBooks(): List<BookmarkItem> {
        return bookSearchDao.getFavoriteBooks()
    }

    companion object {
        private var INSTANCE: FavoriteBookRepositoryImpl? = null

        fun getInstance(bookSearchDao: BookSearchDao): FavoriteBookRepository =
            INSTANCE ?: FavoriteBookRepositoryImpl(bookSearchDao).also { INSTANCE = it }
    }
}

