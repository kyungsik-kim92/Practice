package com.example.naverbooksearch.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.naverbooksearch.data.repo.FavoriteBookRepository
import com.example.naverbooksearch.model.Item
import kotlinx.coroutines.launch

class FavoriteViewModel(private val favoriteBookRepository: FavoriteBookRepository) : ViewModel() {


    fun saveBook(item: Item) = viewModelScope.launch {
        favoriteBookRepository.insertBook(item)
    }

    fun deleteBook(item: Item) = viewModelScope.launch {
        favoriteBookRepository.deleteBook(item)
    }

    val favoriteBooks: LiveData<List<Item>> = favoriteBookRepository.getFavoriteBooks()
}