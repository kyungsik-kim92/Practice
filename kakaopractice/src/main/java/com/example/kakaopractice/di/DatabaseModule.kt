package com.example.kakaopractice.di

import android.content.Context
import androidx.room.Room
import com.example.kakaopractice.room.BookSearchDao
import com.example.kakaopractice.room.BookSearchDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun databaseModule (@ApplicationContext context: Context) :BookSearchDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            BookSearchDatabase::class.java,
            "favorite-books"
        ).fallbackToDestructiveMigration()
            .build()


    @Provides
    @Singleton
    fun daoModule (database : BookSearchDatabase) : BookSearchDao =
        database.bookSearchDao()



}


