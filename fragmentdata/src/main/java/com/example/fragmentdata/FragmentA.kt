package com.example.fragmentdata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentdata.databinding.FragmentABinding


class FragmentA : Fragment() {
    private lateinit var binding : FragmentABinding


    private val mainViewModel by activityViewModels<MainViewModel>()

    private val aViewModel by lazy {
        ViewModelProvider(requireActivity())[AViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        aViewModel.sendValueLiveData.observe(viewLifecycleOwner) {
            mainViewModel.sendData(it)
        }


        binding.tvFragmentA.setOnClickListener {
            aViewModel.sendData("Clicked")

        }


    }
}
