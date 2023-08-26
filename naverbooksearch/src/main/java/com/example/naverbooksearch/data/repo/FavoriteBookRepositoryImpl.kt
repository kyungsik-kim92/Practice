package com.example.naverbooksearch.data.repo

import androidx.lifecycle.LiveData
import com.example.naverbooksearch.data.BookSearchDatabase
import com.example.naverbooksearch.model.Item

class FavoriteBookRepositoryImpl(private var db : BookSearchDatabase) :FavoriteBookRepository {

    override suspend fun insertBook(item: Item) {
        db.bookSearchDao().insertBook(item)

    }

    override suspend fun deleteBook(item: Item) {
        db.bookSearchDao().deleteBook(item)
    }

    override fun getFavoriteBooks(): LiveData<List<Item>> {
        return db.bookSearchDao().getFavoriteBooks()
    }

}