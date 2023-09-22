package com.example.kakaopractice.ui.search

import com.example.kakaopractice.network.response.KakaoBookItem
import kotlinx.coroutines.flow.Flow


interface SearchManager {


    val searchEvent: Flow<SearchViewEvent>


    suspend fun searchBook(query: String)


    suspend fun routeBook(item: KakaoBookItem)

    suspend fun addBookMark(item: KakaoBookItem)

    suspend fun deleteBookMark(item: KakaoBookItem)

}