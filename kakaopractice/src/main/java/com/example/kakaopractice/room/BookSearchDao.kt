package com.example.kakaopractice.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kakaopractice.network.response.KakaoBookItem


@Dao
interface BookSearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(item: BookMarkItem)

    @Delete
    suspend fun deleteBook(item: BookMarkItem)

    @Query("SELECT * FROM book")
    fun getFavoriteBooks() : List<BookMarkItem>

}