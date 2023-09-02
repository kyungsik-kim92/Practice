package com.example.kakaopractice.ui.book

import androidx.lifecycle.viewModelScope
import com.example.kakaopractice.base.BaseViewModel
import com.example.kakaopractice.data.repo.BookMarkRepository
import com.example.kakaopractice.network.response.KakaoBookItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookInfoViewModel@Inject constructor(private val bookMarkRepository: BookMarkRepository) : BaseViewModel() {


    fun addBookMark(item: KakaoBookItem) {


        viewModelScope.launch(Dispatchers.IO) {

            bookMarkRepository.insertBook(item.toBookmarkItem())
            // 이 부분 BaseViewModel에 맞게 바꾸는 법을 모르겠습니다....


        }

    }


    fun deleteBookMark(item: KakaoBookItem) {

        viewModelScope.launch(Dispatchers.IO) {

            bookMarkRepository.deleteBook(item.toBookmarkItem())
        }


    }
}