package com.example.kakaopractice.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kakaopractice.base.BaseViewModel
import com.example.kakaopractice.data.repo.BookMarkRepository
import com.example.kakaopractice.data.repo.SearchBookRepository
import com.example.kakaopractice.network.response.KakaoBookItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchBookRepository: SearchBookRepository,
    private val bookMarkRepository: BookMarkRepository
) :
    BaseViewModel() {

    val inputSearchLiveData = MutableLiveData("")

    fun searchBooks() = viewModelScope.launch(IO) {
        inputSearchLiveData.value?.let { input ->

            val response = searchBookRepository.searchBooks(
                input,
                DEFAULT_SEARCH_SORT,
                DEFAULT_SEARCH_PAGE,
                DEFAULT_SEARCH_SIZE
            )
            if (response.isSuccessful) {

                val getBookmarkList = bookMarkRepository.getFavoriteBooks()
                response.body()?.let { body ->
                    val searchList = body.kakaoBookItems
                    searchList.map { searchItem ->
                        if (getBookmarkList.contains(searchItem.toBookmarkItem())) {
                            searchItem.isBookmark = true
                        }
                    }
                    onChangedViewState(SearchViewState.GetSearchResult(searchList))
                }
            }
        }
    }

    fun addBookMark(item: KakaoBookItem) {
        viewModelScope.launch(IO) {
            val addBookmarkResult = bookMarkRepository.insertBook(item.toBookmarkItem())
            onChangedViewState(
                SearchViewState.AddBookmarkResult(
                    addBookmarkResult >= 1L,
                    item
                ),
            )
        }

    }


    fun deleteBookMark(item: KakaoBookItem) {
        viewModelScope.launch(IO) {
            val deleteBookmarkResult = bookMarkRepository.deleteBook(item.toBookmarkItem())
            onChangedViewState(
                SearchViewState.DeleteBookmarkResult(
                    deleteBookmarkResult == 1,
                    item
                )
            )
        }
    }


    companion object {

        private const val DEFAULT_SEARCH_SORT = "accuracy"
        private const val DEFAULT_SEARCH_PAGE = 1
        private const val DEFAULT_SEARCH_SIZE = 30

    }
}


