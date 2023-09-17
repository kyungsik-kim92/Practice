package com.example.kakaopractice.ui.book

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.kakaopractice.base.BaseViewModel
import com.example.kakaopractice.data.repo.BookMarkRepository
import com.example.kakaopractice.network.response.KakaoBookItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BookInfoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val bookMarkRepository: BookMarkRepository
) :
    BaseViewModel() {

    private val kakaoBookItem = savedStateHandle.get<KakaoBookItem>("item")

    val isBookmark = ObservableBoolean(kakaoBookItem?.isBookmark ?: false)

    fun onCheckedChanged(check: Boolean) {

        kakaoBookItem?.let {
            if(check){
                addBookMark(kakaoBookItem)
            } else{
                deleteBookMark(kakaoBookItem)
            }
        }
    }

    private fun addBookMark(item: KakaoBookItem) {
        viewModelScope.launch(Dispatchers.IO) {
            val addBookmarkResult = bookMarkRepository.insertBook(item.toBookmarkItem())
            onChangedViewState(BookInfoViewState.AddBookmarkResult(addBookmarkResult >= 1L, item))
            withContext(Dispatchers.Main) {
                isBookmark.set(true)
            }
        }
    }

    private fun deleteBookMark(item: KakaoBookItem) {
        viewModelScope.launch(Dispatchers.IO) {
            val deleteBookmarkResult = bookMarkRepository.deleteBook(item.toBookmarkItem())
            onChangedViewState(
                BookInfoViewState.DeleteBookmarkResult(
                    deleteBookmarkResult == 1,
                    item
                )
            )
            withContext(Dispatchers.Main){
                isBookmark.set(false)
            }
        }
    }
}