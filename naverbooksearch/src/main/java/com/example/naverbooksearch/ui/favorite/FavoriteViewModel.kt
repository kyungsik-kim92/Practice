package com.example.naverbooksearch.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.naverbooksearch.data.repo.FavoriteBookRepository
import com.example.naverbooksearch.network.response.NaverBookItem
import com.example.naverbooksearch.room.BookmarkItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoriteViewModel(private val favoriteBookRepository: FavoriteBookRepository) : ViewModel() {

    private val _favoriteBooks = MutableLiveData<List<BookmarkItem>>()
    val favoriteBooks: LiveData<List<BookmarkItem>> = _favoriteBooks


    init {
        getFavoriteBooks()
    }

    fun saveBook(item: BookmarkItem) = viewModelScope.launch {
        favoriteBookRepository.insertBook(item)
    }

    fun deleteBook(item: BookmarkItem) = viewModelScope.launch(IO) {
        favoriteBookRepository.deleteBook(item)
        getFavoriteBooks()
    }

    fun getFavoriteBooks() {
        viewModelScope.launch(IO) {

            val bookmarkList = favoriteBookRepository.getFavoriteBooks()

            withContext(Dispatchers.Main) {
                _favoriteBooks.value = bookmarkList
            }
        }
    }
}

