package com.example.kakaopractice.data.repo


import com.example.kakaopractice.room.BookMarkItem
import com.example.kakaopractice.room.BookSearchDao
import javax.inject.Inject


class BookMarkRepositoryImpl @Inject constructor(private var bookSearchDao: BookSearchDao) :
    BookMarkRepository {
    override suspend fun insertBook(item: BookMarkItem) : Long =
        bookSearchDao.insertBook(item)

    override suspend fun deleteBook(item: BookMarkItem) : Int =
        bookSearchDao.deleteBook(item)
    override fun getFavoriteBooks(): List<BookMarkItem> {
        return bookSearchDao.getFavoriteBooks()
    }


}