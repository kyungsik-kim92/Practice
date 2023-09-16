package com.example.marvelapipractice.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.marvelapipractice.data.repo.MarvelRepository
import com.example.marvelapipractice.util.InjectUtil

class HomeViewModelFactory(private val marvelRepository: MarvelRepository = InjectUtil.provideHomeRepository()
) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(marvelRepository) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}