package com.example.kakaopractice.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kakaopractice.data.repo.SearchBookRepository
import com.example.kakaopractice.util.InjectUtil

class SearchViewModelProviderFactory(private val searchBookRepository: SearchBookRepository = InjectUtil.provideSearchBookRepository()) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return SearchViewModel(searchBookRepository) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}