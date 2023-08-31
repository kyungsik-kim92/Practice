package com.example.kakaopractice.util

import android.content.Context
import com.example.kakaopractice.data.repo.BookMarkRepository
import com.example.kakaopractice.data.repo.BookMarkRepositoryImpl
import com.example.kakaopractice.data.repo.SearchBookRepository
import com.example.kakaopractice.data.repo.SearchBookRepositoryImpl
import com.example.kakaopractice.room.BookSearchDao
import com.example.kakaopractice.room.BookSearchDatabase

object InjectUtil {

    fun provideSearchBookRepository(): SearchBookRepository =
        SearchBookRepositoryImpl.getInstance()

    private fun provideBookSearchDao(context: Context): BookSearchDao =
        BookSearchDatabase.getInstance(context).bookSearchDao()
    fun providerBookMarkRepository(context: Context): BookMarkRepository =
        BookMarkRepositoryImpl.getInstance(provideBookSearchDao(context))
}