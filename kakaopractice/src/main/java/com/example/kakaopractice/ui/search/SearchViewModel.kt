package com.example.kakaopractice.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kakaopractice.base.BaseViewModel
import com.example.kakaopractice.base.ViewEvent
import com.example.kakaopractice.data.repo.BookMarkRepository
import com.example.kakaopractice.data.repo.SearchBookRepository
import com.example.kakaopractice.network.response.KakaoBookItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(private val searchManager: SearchManager) :
    BaseViewModel() {

    override val uiEvent: Flow<ViewEvent>
        get() = searchManager.searchEvent

    private val inputSearchStateFlow = MutableStateFlow("")

    init {
        viewModelScope.launch {
            inputSearchStateFlow.debounce(1000L).collect { searchManager.searchBook(it) }
        }
    }

    fun searchBooks() = viewModelScope.launch(IO) {
        searchManager.searchBook(inputSearchStateFlow.value)

    }

    fun addBookMark(item: KakaoBookItem) {
        viewModelScope.launch(IO) {
            searchManager.addBookMark(item)
        }
    }


    fun deleteBookMark(item: KakaoBookItem) {
        viewModelScope.launch(IO) {
            searchManager.deleteBookMark(item)
        }
    }


}


