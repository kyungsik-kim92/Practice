package com.example.kakaopractice.home

import com.example.kakaopractice.base.BaseViewModel
import com.example.kakaopractice.network.response.KakaoBookItem

class HomeViewModel : BaseViewModel() {

    fun routeBookInfo(item: KakaoBookItem) {
        onChangedViewState(HomeViewState.RouteBookInfo(item))
    }

}
