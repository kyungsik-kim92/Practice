package com.example.kakaopractice.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kakaopractice.base.BaseViewModel
import com.example.kakaopractice.data.repo.BookMarkRepository
import com.example.kakaopractice.room.BookMarkItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookMarkViewModel(private val bookMarkRepository: BookMarkRepository) : BaseViewModel() {

//    private val bookMarkBooks = MutableLiveData<List<BookMarkItem>>()

    init {
        getFavoriteBooks()
    }

    fun saveBook(item: BookMarkItem) = viewModelScope.launch {
        bookMarkRepository.insertBook(item)
    }

    fun deleteBook(item: BookMarkItem) = viewModelScope.launch(Dispatchers.IO) {
        bookMarkRepository.deleteBook(item)
        getFavoriteBooks()
    }

     fun getFavoriteBooks() {
        viewModelScope.launch(Dispatchers.IO) {

            val bookmarkList = bookMarkRepository.getFavoriteBooks()

            withContext(Dispatchers.Main) {
                onChangedViewState(BookMarkViewState.BookMarkResult(bookmarkList))
            }
        }
    }
}