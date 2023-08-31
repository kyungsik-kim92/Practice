package com.example.kakaopractice.ui.book

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kakaopractice.base.BaseViewModel
import com.example.kakaopractice.data.repo.BookMarkRepository
import com.example.kakaopractice.network.response.KakaoBookItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookInfoViewModel(private val bookMarkRepository: BookMarkRepository) : BaseViewModel() {


    fun addBookMark(item: KakaoBookItem) {


        viewModelScope.launch(Dispatchers.IO) {

           bookMarkRepository.insertBook(item.toBookmarkItem())
            // 이 부분 바꾸는 법을 모르겠습니다....



        }

    }


}