package com.example.naverbooksearch.util

import androidx.lifecycle.ViewModel
import com.example.naverbooksearch.data.repo.FavoriteBookRepository
import com.example.naverbooksearch.ui.book.BookInfoViewModel
import com.example.naverbooksearch.ui.favorite.FavoriteViewModel

class FavoriteViewModelFactory(private val favoriteBookRepository: FavoriteBookRepository) :
    androidx.lifecycle.ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FavoriteViewModel(favoriteBookRepository) as T
    }
}


class BookInfoViewModelFactory(private val favoriteBookRepository: FavoriteBookRepository) :
    androidx.lifecycle.ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BookInfoViewModel(favoriteBookRepository) as T
    }
}
