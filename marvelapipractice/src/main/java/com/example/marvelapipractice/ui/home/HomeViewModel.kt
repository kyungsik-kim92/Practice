package com.example.marvelapipractice.ui.home

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelapipractice.api.RetrofitInstance
import com.example.marvelapipractice.api.constants.Constants
import com.example.marvelapipractice.api.constants.Constants.API_KEY
import com.example.marvelapipractice.api.constants.Constants.hash
import com.example.marvelapipractice.api.constants.Constants.timeStamp
import com.example.marvelapipractice.data.repo.HomeRepository
import com.example.marvelapipractice.network.response.Character
import com.example.marvelapipractice.network.response.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {



    private val _bookmarkCharacter = MutableLiveData<MutableList<Result>>()
    val bookmarkCharacter: LiveData<MutableList<Result>> = _bookmarkCharacter

    @SuppressLint("NotifyDataSetChanged")
    fun searchCharacter() {
        CoroutineScope(Dispatchers.IO).launch {

            val call: Response<Character> = homeRepository.getAllCharacters(
                "/v1/public/characters?" + "ts=" + timeStamp + "&apikey=" + API_KEY + "&hash=" + hash()
            )
            val characters : List<Result>? = call.body()?.data?.results
            withContext(Dispatchers.Main) {
                if(call.isSuccessful) {
                    _bookmarkCharacter.value?.clear()
                    if (characters != null) {
                        _bookmarkCharacter.value?.addAll(characters)

                    }
                } else {

                }
            }
        }
    }


}





