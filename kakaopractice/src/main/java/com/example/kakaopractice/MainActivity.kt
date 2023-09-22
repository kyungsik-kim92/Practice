package com.example.kakaopractice

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.kakaopractice.base.BaseViewModel
import com.example.kakaopractice.base.ViewEvent
import com.example.kakaopractice.network.response.KakaoBookItem
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
//    private val mainViewModel by viewModels<MainViewModel>()


}


@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {


    fun addBookmark(item: KakaoBookItem) {
        onChangedViewState(MainViewState.AddBookmark(item))
    }

    fun deleteBookmark(item: KakaoBookItem) {
        onChangedViewState(MainViewState.DeleteBookmark(item))
    }

    override val uiEvent: Flow<ViewEvent>
        get() = TODO("Not yet implemented")

}


sealed class MainViewState : BaseViewModel.ViewState {
    data class AddBookmark(val item: KakaoBookItem) : MainViewState()
    data class DeleteBookmark(val item: KakaoBookItem) : MainViewState()
}