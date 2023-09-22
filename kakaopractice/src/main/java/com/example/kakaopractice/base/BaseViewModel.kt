package com.example.kakaopractice.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    abstract val uiEvent: Flow<ViewEvent>


    interface ViewState {
        object Idle : ViewState
    }

}

interface ViewEvent {
    data class ShowToast(val message: String) : ViewEvent
}
