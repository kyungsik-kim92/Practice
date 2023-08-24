package com.example.fragmentdata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentdata.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    lateinit var binding : MainFragmentBinding

    private val fragmentA = FragmentA()
    private val fragmentB = FragmentB()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.beginTransaction().replace(
            R.id.frameA, fragmentA
        ).commit()

        parentFragmentManager.beginTransaction().replace(
            R.id.frameB, fragmentB
        ).commit()
    }
}