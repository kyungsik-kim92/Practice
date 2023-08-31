package com.example.kakaopractice.ui.book

import com.example.kakaopractice.base.ViewState
import com.example.kakaopractice.network.response.KakaoBookItem

sealed class BookInfoViewState : ViewState {


    data class AddBookMark(val item: KakaoBookItem) : BookInfoViewState()

}