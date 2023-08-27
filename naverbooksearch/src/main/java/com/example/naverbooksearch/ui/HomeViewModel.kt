package com.example.naverbooksearch.ui

import com.example.naverbooksearch.base.BaseViewModel
import com.example.naverbooksearch.network.response.NaverBookItem

class HomeViewModel : BaseViewModel() {

    fun routeBookInfo(item: NaverBookItem) {
        onChangedViewState(HomeViewState.RouteBookInfo(item))
    }
}