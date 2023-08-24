package com.example.fragmentdata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentdata.databinding.FragmentBBinding

class FragmentB : Fragment() {
    private lateinit var binding: FragmentBBinding

    private val childFragment1 = BChildFragment1()
    private val childFragment2 = BChildFragment2()

    private val bViewModel by viewModels<BViewModel>()

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.beginTransaction().replace(
            R.id.childFragment1, childFragment1
        ).commit()

        childFragmentManager.beginTransaction().replace(
            R.id.childFragment2, childFragment2
        ).commit()


        mainViewModel.sendValueLiveData.observe(viewLifecycleOwner) {
            bViewModel.sendData(it)

        }


    }


}