package com.example.naverbooksearch.ui.book

import androidx.lifecycle.viewModelScope
import com.example.naverbooksearch.base.BaseViewModel
import com.example.naverbooksearch.data.repo.FavoriteBookRepository
import com.example.naverbooksearch.network.response.NaverBookItem
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class BookInfoViewModel(private val favoriteBookRepository: FavoriteBookRepository) :
    BaseViewModel() {


    fun addBookmark(item: NaverBookItem) {


        viewModelScope.launch(IO) {

            favoriteBookRepository.insertBook(item.toBookmarkItem())
        }

    }


}