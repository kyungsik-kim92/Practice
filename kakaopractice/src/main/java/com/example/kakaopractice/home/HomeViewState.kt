package com.example.kakaopractice.home

import com.example.kakaopractice.base.ViewState
import com.example.kakaopractice.network.response.KakaoBookItem
import com.example.kakaopractice.room.BookMarkItem

sealed class HomeViewState : ViewState {
    data class RouteBookInfo(val item: KakaoBookItem) : HomeViewState()


    data class AddBookmark(val item: KakaoBookItem) : HomeViewState()

    data class DeleteBookmark(val item: KakaoBookItem) : HomeViewState()
}