package com.example.naverbooksearch.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.naverbooksearch.model.Item


@Dao
interface BookSearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(item: Item)

    @Delete
    suspend fun deleteBook(item: Item)

    @Query("SELECT * FROM book")
    fun getFavoriteBooks() : LiveData<List<Item>>





}