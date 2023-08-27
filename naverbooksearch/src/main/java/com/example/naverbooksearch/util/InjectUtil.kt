package com.example.naverbooksearch.util

import android.content.Context
import com.example.naverbooksearch.data.repo.FavoriteBookRepository
import com.example.naverbooksearch.data.repo.FavoriteBookRepositoryImpl
import com.example.naverbooksearch.data.repo.SearchBookRepository
import com.example.naverbooksearch.data.repo.SearchBookRepositoryImpl
import com.example.naverbooksearch.room.BookSearchDao
import com.example.naverbooksearch.room.BookSearchDatabase

object InjectUtil {


    fun provideSearchBookRepository(): SearchBookRepository =
        SearchBookRepositoryImpl.getInstance()


    private fun provideBookSearchDao(context: Context): BookSearchDao =
        BookSearchDatabase.getInstance(context).bookSearchDao()

    fun provideFavoriteBookRepository(context: Context): FavoriteBookRepository =
        FavoriteBookRepositoryImpl.getInstance(provideBookSearchDao(context))

}