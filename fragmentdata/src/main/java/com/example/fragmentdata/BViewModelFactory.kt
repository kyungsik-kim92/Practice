package com.example.fragmentdata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BViewModel() as T
    }
}