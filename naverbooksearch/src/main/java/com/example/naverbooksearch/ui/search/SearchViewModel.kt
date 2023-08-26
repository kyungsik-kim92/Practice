package com.example.naverbooksearch.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.naverbooksearch.base.BaseViewModel
import com.example.naverbooksearch.constants.NaverConstants
import com.example.naverbooksearch.model.Item
import com.example.naverbooksearch.data.repo.SearchBookRepository
import kotlinx.coroutines.launch

class SearchViewModel(private val searchBookRepository: SearchBookRepository) : BaseViewModel() {

    val inputSearchLiveData = MutableLiveData("")


    fun searchBooks() = viewModelScope.launch {
        inputSearchLiveData.value?.let { input ->

            val response = searchBookRepository.searchBooks(
                NaverConstants.CLIENT_ID,
                NaverConstants.CLIENT_SECRET,
                input,
                DEFAULT_SEARCH_DISPLAY,
                DEFAULT_SEARCH_START,
                DEFAULT_SEARCH_SORT
            )
            if (response.isSuccessful) {
                response.body()?.let { body ->
                    onChangedViewState(SearchViewState.GetSearchResult(body.items))
                }
            }
        }


    }

    fun routeBook(item: Item) = viewModelScope.launch {
        onChangedViewState(SearchViewState.RouteBook(item))


    }



    companion object {

        private const val DEFAULT_SEARCH_DISPLAY = 15
        private const val DEFAULT_SEARCH_START = 1
        private const val DEFAULT_SEARCH_SORT = "sim"
    }


}