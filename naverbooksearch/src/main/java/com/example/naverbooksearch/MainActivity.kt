package com.example.naverbooksearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.naverbooksearch.databinding.ActivityMainBinding
import com.example.naverbooksearch.repo.SearchBookRepositoryImpl
import com.example.naverbooksearch.viewmodel.BookSearchViewModelProviderFactory
import com.example.naverbooksearch.viewmodel.SearchBookViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var searchBookViewModel: SearchBookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val searchBookRepository =
            SearchBookRepositoryImpl() // 이 코드 쓰지 말라고 하셨는데 어떻게 바꿨는지 기억이 안납니다..

        val factory = BookSearchViewModelProviderFactory(searchBookRepository)
        searchBookViewModel = ViewModelProvider(this, factory)[SearchBookViewModel::class.java]
    }



}
