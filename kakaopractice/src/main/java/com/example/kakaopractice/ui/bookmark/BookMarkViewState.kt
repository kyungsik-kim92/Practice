package com.example.kakaopractice.ui.bookmark

import com.example.kakaopractice.base.ViewState
import com.example.kakaopractice.network.response.KakaoBookItem
import com.example.kakaopractice.room.BookMarkItem
import com.example.kakaopractice.ui.search.SearchViewState

sealed class BookMarkViewState : ViewState {


    data class BookMarkResult(val list : List<BookMarkItem>): BookMarkViewState()


}