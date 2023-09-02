package com.example.kakaopractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kakaopractice.data.repo.SearchBookRepositoryImpl
import com.example.kakaopractice.databinding.ActivityMainBinding
import com.example.kakaopractice.ui.search.SearchFragment
import com.example.kakaopractice.ui.search.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main)


