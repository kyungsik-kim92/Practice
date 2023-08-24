package com.example.fragmentdata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel() {


    private val _sendValueLiveData = MutableLiveData("")
    val sendValueLiveData: LiveData<String> = _sendValueLiveData


    fun sendData(data: String) {
        _sendValueLiveData.value = data
    }
}