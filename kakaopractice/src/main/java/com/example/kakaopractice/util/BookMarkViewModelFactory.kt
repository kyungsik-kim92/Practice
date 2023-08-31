package com.example.kakaopractice.util

import androidx.lifecycle.ViewModel
import com.example.kakaopractice.ui.bookmark.BookMarkViewModel
import com.example.kakaopractice.data.repo.BookMarkRepository
import com.example.kakaopractice.ui.book.BookInfoViewModel

class BookMarkViewModelFactory (private val bookMarkRepository: BookMarkRepository) :
    androidx.lifecycle.ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BookMarkViewModel(bookMarkRepository) as T
    }
}


class BookInfoViewModelFactory(private val bookMarkRepository: BookMarkRepository) :
    androidx.lifecycle.ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BookInfoViewModel(bookMarkRepository) as T
    }
}