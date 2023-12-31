package com.example.kakaopractice.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kakaopractice.network.response.KakaoBookItem
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Dao
interface BookSearchDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(item: BookMarkItem) : Long


    @Delete
    suspend fun deleteBook(item: BookMarkItem) : Int


    @Query("SELECT * FROM book")
    fun getFavoriteBooks(): List<BookMarkItem>

}