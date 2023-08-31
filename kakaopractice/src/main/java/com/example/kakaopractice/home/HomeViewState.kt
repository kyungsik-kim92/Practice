package com.example.kakaopractice.home

import com.example.kakaopractice.base.ViewState
import com.example.kakaopractice.network.response.KakaoBookItem

sealed class HomeViewState : ViewState {
    data class RouteBookInfo(val item: KakaoBookItem) : HomeViewState()

}