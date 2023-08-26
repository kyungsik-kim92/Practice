package com.example.naverbooksearch.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.naverbooksearch.data.repo.FavoriteBookRepository
import com.example.naverbooksearch.util.InjectUtil

//class FavoriteViewModelProviderFactory(private val favoriteBookRepository: FavoriteBookRepository=InjectUtil.provideFavoriteBookRepository())
// : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)) {
//            return FavoriteViewModel(favoriteBookRepository) as T
//        }
//        throw IllegalArgumentException("ViewModel class not found")
//    }
//
//
//}