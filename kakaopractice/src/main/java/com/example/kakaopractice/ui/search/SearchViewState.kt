package com.example.kakaopractice.ui.search

import com.example.kakaopractice.base.ViewState
import com.example.kakaopractice.network.response.KakaoBookItem
import com.example.kakaopractice.room.BookMarkItem

sealed class SearchViewState : ViewState {

    data class GetSearchResult(val list : List<KakaoBookItem>): SearchViewState()


    data class BookMarkResult(val list : List<KakaoBookItem>) : SearchViewState()

}