package com.example.marvelapipractice

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelapipractice.adapter.MarvelAdapter
import com.example.marvelapipractice.api.RetrofitInstance
import com.example.marvelapipractice.api.constants.Constants
import com.example.marvelapipractice.api.constants.Constants.API_KEY
import com.example.marvelapipractice.api.constants.Constants.hash
import com.example.marvelapipractice.api.constants.Constants.timeStamp
import com.example.marvelapipractice.databinding.ActivityMainBinding
import com.example.marvelapipractice.model.Character
import com.example.marvelapipractice.model.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val marvelNames = mutableListOf<Result>()

    private lateinit var recyclerViewAdapter : MarvelAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)


        recyclerViewAdapter = MarvelAdapter(marvelNames)
        binding.rvCharacter.adapter = recyclerViewAdapter
        binding.rvCharacter.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        searchCharacter()


    }



        @SuppressLint("NotifyDataSetChanged")
        fun searchCharacter() {
            CoroutineScope(Dispatchers.IO).launch {

                val call: Response<Character> = RetrofitInstance.api.getAllCharacters(
                    "/v1/public/characters?" + "ts=" + timeStamp + "&apikey=" + API_KEY + "&hash=" + hash()
                )
                val characters : List<Result>? = call.body()?.data?.results
                withContext(Dispatchers.Main) {
                    if(call.isSuccessful) {
                        marvelNames.clear()
                        if (characters != null) {
                            marvelNames.addAll(characters)
                            recyclerViewAdapter.notifyDataSetChanged()
                        }
                    } else {

                    }
                }
            }
        }

}




