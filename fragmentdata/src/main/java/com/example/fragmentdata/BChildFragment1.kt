package com.example.fragmentdata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentdata.databinding.FragmentBChild1Binding

class BChildFragment1 : Fragment() {

    private lateinit var binding: FragmentBChild1Binding

    private val bViewModel by viewModels<BViewModel>(
        ownerProducer = {requireParentFragment()},
        factoryProducer = {BViewModelFactory()}
    )




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBChild1Binding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        bViewModel.sendValueLiveData.observe(viewLifecycleOwner) {
            binding.tvChildFragment1.text = it

        }
    }
}


