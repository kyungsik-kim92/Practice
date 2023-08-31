package com.example.kakaopractice.ui.search

import com.example.kakaopractice.base.ViewState
import com.example.kakaopractice.network.response.KakaoBookItem

sealed class SearchViewState : ViewState {

    data class GetSearchResult(val list : List<KakaoBookItem>): SearchViewState()

}