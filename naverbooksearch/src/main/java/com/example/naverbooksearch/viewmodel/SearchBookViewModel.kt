package com.example.naverbooksearch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.naverbooksearch.constants.NaverConstants
import com.example.naverbooksearch.model.Item
import com.example.naverbooksearch.repo.SearchBookRepository
import kotlinx.coroutines.launch

class SearchBookViewModel(private val searchBookRepository: SearchBookRepository) : ViewModel() {


    private val _searchResultLiveData = MutableLiveData<List<Item>>()
    val searchResultLiveData: LiveData<List<Item>> = _searchResultLiveData


    fun searchBooks(query: String) = viewModelScope.launch {

        val response = searchBookRepository.searchBooks(
            NaverConstants.CLIENT_ID,
            NaverConstants.CLIENT_SECRET,
            query,
            DEFAULT_SEARCH_DISPLAY,
            DEFAULT_SEARCH_START,
            DEFAULT_SEARCH_SORT
        )
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _searchResultLiveData.value = body.items
            }
        }

    }


    companion object {

        private const val DEFAULT_SEARCH_DISPLAY = 15
        private const val DEFAULT_SEARCH_START = 1
        private const val DEFAULT_SEARCH_SORT = "sim"
    }


}