package com.example.marvelapipractice.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.marvelapipractice.network.response.Result


@Database(
    entities = [Result::class],
    version = 1,
    exportSchema = false
)
abstract class MarvelDatabase : RoomDatabase() {

    abstract fun marvelDao(): MarvelDao
}