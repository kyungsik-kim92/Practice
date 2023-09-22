package com.example.kakaopractice.ui.search

import com.example.kakaopractice.base.ViewEvent
import com.example.kakaopractice.data.repo.BookMarkRepository
import com.example.kakaopractice.data.repo.SearchBookRepository
import com.example.kakaopractice.network.response.KakaoBookItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

class SearchManagerImpl @Inject constructor(private val searchBookRepository: SearchBookRepository,
                                            private val bookMarkRepository: BookMarkRepository) :
    SearchManager {
    override val searchEvent: Flow<SearchViewEvent>
        get() = _searchEvent
    private val _searchEvent = MutableSharedFlow<SearchViewEvent>()
    override suspend fun searchBook(query: String) {
        if(query.isEmpty()) return

        val response = searchBookRepository.searchBooks(
            query,
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
                _searchEvent.emit(SearchViewEvent.GetSearchResult(body.kakaoBookItems))
            }
        }
    }

    override suspend fun routeBook(item: KakaoBookItem) {
        _searchEvent.emit(SearchViewEvent.RouteBook(item))

    }

    override suspend fun addBookMark(item: KakaoBookItem) {

        val addBookmarkResult = bookMarkRepository.insertBook(item.toBookmarkItem())
        _searchEvent.emit(
            SearchViewEvent.AddBookMark(
                addBookmarkResult >= 1L,
                item
            ),
        )

    }

    override suspend fun deleteBookMark(item: KakaoBookItem) {
        val deleteBookmarkResult = bookMarkRepository.deleteBook(item.toBookmarkItem())
        _searchEvent.emit(
            SearchViewEvent.DeleteBookMark(
                deleteBookmarkResult == 1,
                item
            )
        )
    }


    companion object {

        private const val DEFAULT_SEARCH_SORT = "accuracy"
        private const val DEFAULT_SEARCH_PAGE = 1
        private const val DEFAULT_SEARCH_SIZE = 30

    }

}

sealed interface SearchViewEvent : ViewEvent {
    data class GetSearchResult(val list: List<KakaoBookItem>) : SearchViewEvent
    data class RouteBook(val item: KakaoBookItem) : SearchViewEvent
    data class AddBookMark(val result: Boolean,val item: KakaoBookItem) : SearchViewEvent
    data class DeleteBookMark(val result: Boolean,val item: KakaoBookItem) : SearchViewEvent

}
