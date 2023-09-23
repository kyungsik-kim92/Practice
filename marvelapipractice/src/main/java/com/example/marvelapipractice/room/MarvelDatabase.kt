package com.example.marvelapipractice.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.marvelapipractice.network.response.Result
import com.example.marvelapipractice.util.ItemTypeConverter
import com.example.marvelapipractice.util.UrlTypeConverter


@Database(
    entities = [Result::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    value = [UrlTypeConverter::class, ItemTypeConverter::class]
)
abstract class MarvelDatabase : RoomDatabase() {

    abstract fun marvelDao(): MarvelDao
}