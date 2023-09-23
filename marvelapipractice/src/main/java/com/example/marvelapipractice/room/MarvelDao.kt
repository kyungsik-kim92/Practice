package com.example.marvelapipractice.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvelapipractice.network.response.Result


@Dao
interface MarvelDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(item: Result) : Long


    @Delete
    suspend fun deleteCharacter(item: Result) : Int


    @Query("SELECT * FROM result")
    fun getCharacter(): List<Result>
}