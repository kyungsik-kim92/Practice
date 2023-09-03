package com.example.kakaopractice.ui.book

import com.example.kakaopractice.base.ViewState
import com.example.kakaopractice.network.response.KakaoBookItem
import com.example.kakaopractice.room.BookMarkItem

sealed class BookInfoViewState : ViewState {

    data class AddBookmarkResult(val result: Boolean, val item: KakaoBookItem) : BookInfoViewState()

    data class DeleteBookmarkResult(val result: Boolean, val item: KakaoBookItem) :
        BookInfoViewState()

}