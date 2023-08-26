package com.example.naverbooksearch.data.repo

import androidx.lifecycle.LiveData
import com.example.naverbooksearch.model.Item

interface FavoriteBookRepository {


    // Room
    suspend fun insertBook(item: Item)
    suspend fun deleteBook(item: Item)
    fun getFavoriteBooks() : LiveData<List<Item>>
}