package com.example.marvelapipractice.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.marvelapipractice.R
import com.example.marvelapipractice.databinding.FragmentBookmarkBinding
import com.example.marvelapipractice.databinding.FragmentHomeBinding

class BookmarkFragment : Fragment() {


    lateinit var binding : FragmentBookmarkBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookmark, container, false)
        return binding. root
    }
}