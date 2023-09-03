package com.example.kakaopractice.ui.search

import com.example.kakaopractice.base.ViewState
import com.example.kakaopractice.network.response.KakaoBookItem
import com.example.kakaopractice.room.BookMarkItem
import com.example.kakaopractice.ui.book.BookInfoViewState

sealed class SearchViewState : ViewState {

    data class GetSearchResult(val list: List<KakaoBookItem>) : SearchViewState()


    data class AddBookmarkResult(val result: Boolean, val item: KakaoBookItem) : SearchViewState()

    data class DeleteBookmarkResult(val result: Boolean, val item: KakaoBookItem) : SearchViewState()
}