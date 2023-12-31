package com.example.naverbooksearch.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.naverbooksearch.network.response.NaverBookItem


@Database(
    entities = [BookmarkItem::class],
    version = 1,
    exportSchema = false
)
abstract class BookSearchDatabase : RoomDatabase() {

    abstract fun bookSearchDao(): BookSearchDao

    companion object {
        @Volatile
        private var INSTANCE: BookSearchDatabase? = null

        private fun buildDatabase(context: Context): BookSearchDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                BookSearchDatabase::class.java,
                "favorite-books"
            ).fallbackToDestructiveMigration()
                .build()

        fun getInstance(context: Context): BookSearchDatabase =
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
    }


}