package com.example.kakaopractice.ui.bookmark

import com.example.kakaopractice.base.ViewState
import com.example.kakaopractice.room.BookMarkItem

sealed class BookMarkViewState : ViewState {


    data class BookMarkResult(val list : List<BookMarkItem>): BookMarkViewState()


}