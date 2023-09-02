package com.example.kakaopractice.di

import com.example.kakaopractice.data.repo.BookMarkRepository
import com.example.kakaopractice.data.repo.BookMarkRepositoryImpl
import com.example.kakaopractice.data.repo.SearchBookRepository
import com.example.kakaopractice.data.repo.SearchBookRepositoryImpl
import com.example.kakaopractice.network.BookApiService
import com.example.kakaopractice.room.BookSearchDao
import com.example.kakaopractice.room.BookSearchDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object RepositoryModule {

    @Provides
    @Singleton
    fun provideBookRepository(bookApiService: BookApiService): SearchBookRepository =
        SearchBookRepositoryImpl(bookApiService)


    @Provides
    @Singleton
    fun provideBookMarkRepository(bookSearchDao: BookSearchDao): BookMarkRepository =
        BookMarkRepositoryImpl(bookSearchDao)


}



