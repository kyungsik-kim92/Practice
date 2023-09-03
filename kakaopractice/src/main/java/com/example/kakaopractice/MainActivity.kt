package com.example.kakaopractice

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kakaopractice.base.BaseViewModel
import com.example.kakaopractice.base.ViewState
import com.example.kakaopractice.data.repo.SearchBookRepositoryImpl
import com.example.kakaopractice.databinding.ActivityMainBinding
import com.example.kakaopractice.network.response.KakaoBookItem
import com.example.kakaopractice.ui.search.SearchFragment
import com.example.kakaopractice.ui.search.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val mainViewModel by viewModels<MainViewModel>()
}


@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {

    fun addBookmark(item: KakaoBookItem) {
        onChangedViewState(MainViewState.AddBookmark(item))
    }

    fun deleteBookmark(item: KakaoBookItem) {
        onChangedViewState(MainViewState.DeleteBookmark(item))
    }

}


sealed class MainViewState : ViewState {
    data class AddBookmark(val item: KakaoBookItem) : MainViewState()
    data class DeleteBookmark(val item: KakaoBookItem) : MainViewState()
}