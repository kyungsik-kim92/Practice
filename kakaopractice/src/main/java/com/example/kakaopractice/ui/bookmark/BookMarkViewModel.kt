package com.example.kakaopractice.ui.bookmark

import androidx.lifecycle.viewModelScope
import com.example.kakaopractice.base.BaseViewModel
import com.example.kakaopractice.base.ViewEvent
import com.example.kakaopractice.data.repo.BookMarkRepository
import com.example.kakaopractice.room.BookMarkItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BookMarkViewModel @Inject constructor(private val bookMarkRepository: BookMarkRepository) :
    BaseViewModel() {

//    private val bookMarkBooks = MutableLiveData<List<BookMarkItem>>()

    init {
        getFavoriteBooks()
    }

    fun saveBook(item: BookMarkItem) = viewModelScope.launch(Dispatchers.IO) {
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