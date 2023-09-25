package com.example.timerpractice

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val timerProperty = TimerProperty()

    private lateinit var timerJob: Job

    fun startTimer() {
        if (::timerJob.isInitialized)
            timerJob.cancel()

        timerProperty.clear()

        timerJob = flow {
            while (timerProperty.time > 0) {
                delay(1000L)
                emit(timerProperty.time--)
            }
        }.cancellable().launchIn(viewModelScope)
    }

    class TimerProperty : BaseObservable() {
        @get:Bindable
        var time: Int = INIT_TIME
            set(value) {
                field = value
                notifyPropertyChanged(BR.time)
            }

        @get:Bindable
        var message: String = EMPTY_MESSAGE
            set(value) {
                field = value
                notifyPropertyChanged(BR.message)
            }

        fun clear() {
            time = INIT_TIME
            message = EMPTY_MESSAGE
        }

        companion object {
            private const val INIT_TIME = 10
            private const val EMPTY_MESSAGE = ""
        }
    }
}
