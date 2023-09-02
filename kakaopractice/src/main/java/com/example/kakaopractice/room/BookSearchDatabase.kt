package com.example.kakaopractice.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kakaopractice.util.TypeConverter


@Database(
    entities = [BookMarkItem::class],
    version = 6,
    exportSchema = false
)

@TypeConverters(TypeConverter::class)
abstract class BookSearchDatabase : RoomDatabase(){

    abstract fun bookSearchDao(): BookSearchDao


}