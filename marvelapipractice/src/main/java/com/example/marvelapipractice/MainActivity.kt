package com.example.marvelapipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.marvelapipractice.api.MarvelApiService
import com.example.marvelapipractice.api.constants.Constants
import com.example.marvelapipractice.api.constants.Constants.API_KEY
import com.example.marvelapipractice.api.constants.Constants.hash
import com.example.marvelapipractice.api.constants.Constants.timeStamp
import com.example.marvelapipractice.databinding.ActivityMainBinding
import com.example.marvelapipractice.model.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        val marvelApiService = retrofit.create(MarvelApiService::class.java)



        marvelApiService.getAllCharacters("/v1/public/characters?"+"ts=" + timeStamp + "&apikey=" + API_KEY + "&hash=" + hash())
            .enqueue(object : Callback<Character> {

                override fun onResponse(call: Call<Character>, response: Response<Character>) {
                    Log.d("tag",response.body().toString())
                }

                override fun onFailure(call: Call<Character>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }
}