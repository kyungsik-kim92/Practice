package com.example.marvelapipractice.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.marvelapipractice.R
import com.example.marvelapipractice.adapter.MarvelAdapter
import com.example.marvelapipractice.data.repo.HomeRepository
import com.example.marvelapipractice.databinding.FragmentHomeBinding
import com.example.marvelapipractice.network.response.Result

class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels(
        factoryProducer = {HomeViewModelFactory()}
    )

    private lateinit var recyclerViewAdapter : MarvelAdapter
    private val marvelCharacters = mutableListOf<Result>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding. root
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewAdapter = MarvelAdapter(marvelCharacters)
        binding.rvCharacter.adapter = recyclerViewAdapter

        viewModel.bookmarkCharacter.observe(viewLifecycleOwner){
            viewModel.searchCharacter()


        }
        recyclerViewAdapter.notifyDataSetChanged()
    }
}