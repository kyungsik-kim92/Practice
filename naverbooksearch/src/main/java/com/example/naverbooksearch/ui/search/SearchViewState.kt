package com.example.naverbooksearch.ui.search

import com.example.naverbooksearch.base.ViewState
import com.example.naverbooksearch.model.Item

sealed class SearchViewState : ViewState{

    data class GetSearchResult(val list : List<Item>): SearchViewState()
    data class RouteBook(val item : Item) : SearchViewState()

}