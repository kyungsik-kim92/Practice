package com.example.timerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.timerpractice.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val coroutineScopeMainImmediate = CoroutineScope(Dispatchers.Main.immediate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {


        binding.btnStart.setOnClickListener {

            coroutineScopeMainImmediate.launch {
                binding.tvStatus.text = "start"


                runTime()

                binding.tvStatus.text = "ended"

            }
        }
    }

    private suspend fun runTime() {
        var seconds = 10
        while (seconds >= 0) {
            binding.count.text = "${seconds--}"
            delay(1000)
        }
    }


}