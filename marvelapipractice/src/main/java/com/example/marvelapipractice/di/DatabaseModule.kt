package com.example.marvelapipractice.di

import android.content.Context
import androidx.room.Room
import com.example.marvelapipractice.room.MarvelDao
import com.example.marvelapipractice.room.MarvelDatabase
import com.example.marvelapipractice.util.ItemTypeConverter
import com.example.marvelapipractice.util.UrlTypeConverter
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun databaseModule(@ApplicationContext context: Context,gson: Gson): MarvelDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            MarvelDatabase::class.java,
            "marvel-character"
        ).fallbackToDestructiveMigration()
            .addTypeConverter(UrlTypeConverter(gson))
            .addTypeConverter(ItemTypeConverter(gson))
            .build()


    @Provides
    @Singleton
    fun daoModule(database: MarvelDatabase): MarvelDao =
        database.marvelDao()


}
