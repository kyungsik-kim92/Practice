package com.example.timerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.timerpractice.MainViewModel.Companion.MIllIS_IN_FUTURE
import com.example.timerpractice.MainViewModel.Companion.TICK_INTERVAL
import com.example.timerpractice.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //    private val coroutineScopeMainImmediate = CoroutineScope(Dispatchers.Main.immediate)
    private lateinit var timer: CountDownTimer

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        initViews()
//        setUpCountDownTimer()
        binding.btnStart.setOnClickListener {
            viewModel.customTimerDuration.observe(this) {
                binding.count.text = removeLastNchars(it.toString(), 3)
                viewModel.timerJob.start()

            }
        }
    }

    private fun removeLastNchars(str: String, n: Int): String {
        return str.substring(0, str.length - n)
    }
//    private fun setUpCountDownTimer() {
//        timer = object : CountDownTimer(MIllIS_IN_FUTURE, TICK_INTERVAL) {
//            override fun onTick(millisUntilFinished: Long) {
//                viewModel.countDownTimerDuration.value = millisUntilFinished
//            }
//
//            override fun onFinish() {}
//        }
//    }

//    private fun initViews() {
//
//
//        binding.btnStart.setOnClickListener {
//
//            coroutineScopeMainImmediate.launch {
//                binding.tvStatus.text = "start"
//
//
//                runTime()
//
//                binding.tvStatus.text = "ended"
//
//            }
//        }
//    }
//
//    private suspend fun runTime() {
//        var seconds = 10
//        while (seconds >= 0) {
//            binding.count.text = "${seconds--}"
//            delay(1000)
//        }
//    }


}