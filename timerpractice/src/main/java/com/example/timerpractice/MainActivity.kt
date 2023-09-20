package com.example.timerpractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.timerpractice.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //    private val coroutineScopeMainImmediate = CoroutineScope(Dispatchers.Main.immediate)
//    private lateinit var timer: CountDownTimer
    private var job: Job? = null

//    private val viewModel: MainViewModel by lazy {
//        ViewModelProvider(this)[MainViewModel::class.java]
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        initViews()
////        setUpCountDownTimer()
//        binding.btnStart.setOnClickListener {
//            viewModel.customTimerDuration.observe(this) {
//                binding.count.text = removeLastNchars(it.toString(), 3)
//                viewModel.timerJob.start()
//
//            }
//        }

        binding.btnStart.setOnClickListener {

            job?.cancel()
            job = CoroutineScope(Dispatchers.Main).launch {
                for (i in 10 downTo 0) {
                    binding.count.text = "$i"
                    delay(1000) // 1초 대기
                }
                binding.count.text = "시간 종료!"
            }
        }
    }
override fun onDestroy() {
    super.onDestroy()
    job?.cancel()
}

}


//private fun removeLastNchars(str: String, n: Int): String {
//    return str.substring(0, str.length - n)
//}
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







