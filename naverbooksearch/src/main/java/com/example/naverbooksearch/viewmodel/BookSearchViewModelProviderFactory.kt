package com.example.naverbooksearch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.naverbooksearch.repo.SearchBookRepository


class BookSearchViewModelProviderFactory(private val searchBookRepository: SearchBookRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchBookViewModel::class.java)) {
            return SearchBookViewModel(searchBookRepository) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}