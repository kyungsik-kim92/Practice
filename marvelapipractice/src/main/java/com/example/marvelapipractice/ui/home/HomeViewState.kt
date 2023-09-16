package com.example.marvelapipractice.ui.home

import com.example.marvelapipractice.base.ViewState
import com.example.marvelapipractice.network.response.Result

sealed class HomeViewState : ViewState {
    data class GetData(val result: List<Result>) : HomeViewState()

    data class ShowToast(val message : String) : HomeViewState()

    data class Refresh(val result: List<Result>) : HomeViewState()
}
