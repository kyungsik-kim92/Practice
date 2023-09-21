package com.example.timerpractice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _countdownState = MutableStateFlow(10)
    val countdownState: StateFlow<Int> = _countdownState

    init {
        startCountdown()
    }

    private fun startCountdown() {
        viewModelScope.launch {
            while (_countdownState.value > 0) {
                kotlinx.coroutines.delay(1000)
                _countdownState.value -= 1
            }
        }

    }
        fun resetCountdown() {
            _countdownState.value = 10
        }
}