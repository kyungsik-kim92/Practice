package com.example.marvelapipractice.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelapipractice.R
import com.example.marvelapipractice.adapter.MarvelAdapter
import com.example.marvelapipractice.api.RetrofitInstance
import com.example.marvelapipractice.api.constants.Constants.API_KEY
import com.example.marvelapipractice.api.constants.Constants.hash
import com.example.marvelapipractice.api.constants.Constants.timeStamp
import com.example.marvelapipractice.databinding.ActivityMainBinding
import com.example.marvelapipractice.network.response.Character
import com.example.marvelapipractice.network.response.Result
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

//        binding.rvCharacter.adapter = recyclerViewAdapter
//        binding.rvCharacter.layoutManager =
//            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//
//
//        searchCharacter()


    }



//        @SuppressLint("NotifyDataSetChanged")
//        fun searchCharacter() {
//            CoroutineScope(Dispatchers.IO).launch {
//
//                val call: Response<Character> = RetrofitInstance.api.getAllCharacters(
//                    "/v1/public/characters?" + "ts=" + timeStamp + "&apikey=" + API_KEY + "&hash=" + hash()
//                )
//                val characters : List<Result>? = call.body()?.data?.results
//                withContext(Dispatchers.Main) {
//                    if(call.isSuccessful) {
//                        marvelCharacter.clear()
//                        if (characters != null) {
//                            marvelCharacter.addAll(characters)
//                            recyclerViewAdapter.notifyDataSetChanged()
//                        }
//                    } else {
//
//                    }
//                }
//            }
//        }

}




