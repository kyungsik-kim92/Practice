package com.example.kakaopractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kakaopractice.data.repo.SearchBookRepositoryImpl
import com.example.kakaopractice.databinding.ActivityMainBinding
import com.example.kakaopractice.search.SearchFragment
import com.example.kakaopractice.search.SearchViewModel

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment()

        val searchBookRepository = SearchBookRepositoryImpl()






    }

        fun setFragment(){
            val searchFragment = supportFragmentManager.beginTransaction()
            searchFragment.replace(R.id.frame_layout, SearchFragment()).commit()
        }




}