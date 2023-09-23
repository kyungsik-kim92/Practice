package com.example.marvelapipractice.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.marvelapipractice.R
import com.example.marvelapipractice.databinding.ActivityMainBinding
import com.example.marvelapipractice.ui.adapter.ViewPagerAdapter
import com.example.marvelapipractice.ui.favorite.FavoriteFragment
import com.example.marvelapipractice.ui.home.HomeFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initViewPager()


    }


    private fun initViewPager() {
        //ViewPager2 Adapter 셋팅
        var viewPagerAdapter = ViewPagerAdapter(this)
        viewPagerAdapter.addFragment(HomeFragment())
        viewPagerAdapter.addFragment(FavoriteFragment())


        //Adapter 연결
        binding.viewpager.apply {
            adapter = viewPagerAdapter

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }

        //ViewPager, TabLayout 연결
        TabLayoutMediator(binding.tablayout, binding.viewpager) { tab, position ->
            when (position) {
                0 -> tab.text = "Tab1"
                1 -> tab.text = "Tab2"

            }
        }.attach()
    }
}
