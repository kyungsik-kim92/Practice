package com.example.fragmentpractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentpractice.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val tabConfigurationStrategy =
        TabLayoutMediator.TabConfigurationStrategy { tab, positon ->
            tab.icon = resources.obtainTypedArray(R.array.array_main_tab_icon).getDrawable(positon)
            tab.text = resources.getStringArray(R.array.array_main_tab_text)[positon]

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {

        val list = listOf(
            Fragment1(),
            Fragment2(),
            Fragment3(),
            Fragment4(),
        )

        val pageAdapter = FragmentPagerAdapter(list, this)

        with(binding) {

            viewPager.adapter = pageAdapter

            TabLayoutMediator(tabLayout, viewPager, tabConfigurationStrategy).attach()

        }

    }


}