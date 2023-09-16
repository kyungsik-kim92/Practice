package com.example.marvelapipractice.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.marvelapipractice.R
import com.example.marvelapipractice.databinding.ActivityMainBinding
import com.example.marvelapipractice.util.RetrofitInstance
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        apiTest()
    }

    private fun apiTest() {


        lifecycleScope.launch {

            val body = RetrofitInstance.api.getCharacters(offset = 0, limit = 20).body()

            body?.let {

                it.data.results.forEach {

                    Log.d(
                        "결과", """
                        id : ${it.name}
                        image : ${it.thumbnail.getUrl()}
                        urls : ${it.urls.size} / comics : ${it.comics.available} / series : ${it.series.available} / stories : ${it.stories.available} / events : ${it.events.available}
                    """.trimIndent()
                    )
                }

            } ?: kotlin.run {
                Log.d("결과", "실패")
            }
        }


    }

}




