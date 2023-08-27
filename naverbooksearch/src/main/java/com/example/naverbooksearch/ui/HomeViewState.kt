package com.example.naverbooksearch.ui

import com.example.naverbooksearch.base.ViewState
import com.example.naverbooksearch.network.response.NaverBookItem

sealed class HomeViewState : ViewState {
    data class RouteBookInfo(val item: NaverBookItem) : HomeViewState()
}
