package com.example.naverbooksearch.ui.search

import com.example.naverbooksearch.base.ViewState
import com.example.naverbooksearch.network.response.NaverBookItem
import com.example.naverbooksearch.room.BookmarkItem

sealed class SearchViewState : ViewState{

    data class GetSearchResult(val list : List<NaverBookItem>): SearchViewState()

}