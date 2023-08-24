package com.example.fragmentdata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentdata.databinding.FragmentBChild2Binding

class BChildFragment2 : Fragment() {
    private lateinit var binding : FragmentBChild2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBChild2Binding.inflate(inflater, container, false)
        return binding.root
    }


}