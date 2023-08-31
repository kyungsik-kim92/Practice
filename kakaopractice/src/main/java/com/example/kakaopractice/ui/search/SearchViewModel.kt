package com.example.kakaopractice.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kakaopractice.base.BaseViewModel
import com.example.kakaopractice.data.repo.SearchBookRepository
import com.example.kakaopractice.network.response.KakaoBookItem
import kotlinx.coroutines.launch

class SearchViewModel(private val searchBookRepository: SearchBookRepository) : BaseViewModel() {

    val inputSearchLiveData = MutableLiveData("")

    fun searchBooks() = viewModelScope.launch {
        inputSearchLiveData.value?.let { input ->

            val response = searchBookRepository.searchBooks(
                input,
                DEFAULT_SEARCH_SORT,
                DEFAULT_SEARCH_PAGE,
                DEFAULT_SEARCH_SIZE
            )
            if (response.isSuccessful) {
                response.body()?.let { body ->
                    onChangedViewState(SearchViewState.GetSearchResult(body.kakaoBookItems))
                }
            }
        }


    }


    companion object {

        private const val DEFAULT_SEARCH_SORT = "accuracy"
        private const val DEFAULT_SEARCH_PAGE = 1
        private const val DEFAULT_SEARCH_SIZE = 30
    }

}

