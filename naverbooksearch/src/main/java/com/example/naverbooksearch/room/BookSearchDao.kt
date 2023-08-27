package com.example.naverbooksearch.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.naverbooksearch.network.response.NaverBookItem


@Dao
interface BookSearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(item: BookmarkItem)

    @Delete
    suspend fun deleteBook(item: BookmarkItem)

    @Query("SELECT * FROM book")
    fun getFavoriteBooks() : List<BookmarkItem>

}