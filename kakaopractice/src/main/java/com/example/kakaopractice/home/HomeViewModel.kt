package com.example.kakaopractice.home

import com.example.kakaopractice.base.BaseViewModel
import com.example.kakaopractice.network.response.KakaoBookItem
import com.example.kakaopractice.room.BookMarkItem

class HomeViewModel : BaseViewModel() {

    fun routeBookInfo(item: KakaoBookItem) {
        onChangedViewState(HomeViewState.RouteBookInfo(item))
    }

    fun addBookmark(item : KakaoBookItem){
        onChangedViewState(HomeViewState.AddBookmark(item))
    }

    fun deleteBookmark(item : KakaoBookItem){
        onChangedViewState(HomeViewState.DeleteBookmark(item))
    }

}
