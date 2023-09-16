package com.example.marvelapipractice.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.marvelapipractice.R
import com.example.marvelapipractice.databinding.FragmentHomeBinding
import com.example.marvelapipractice.ext.showToast
import com.example.marvelapipractice.ui.adapter.MarvelAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()

    private val marvelAdapter = MarvelAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = this.viewModel
        binding.rvCharacter.adapter = marvelAdapter

        viewModel.homeViewStateLiveData.observe(viewLifecycleOwner) { viewState ->
            when (viewState) {
                is HomeViewState.GetData -> {
                    marvelAdapter.addAll(viewState.result)
                }

                is HomeViewState.ShowToast -> {
                    showToast(viewState.message)
                }

                is HomeViewState.Refresh -> {
                    marvelAdapter.clear()
                    marvelAdapter.addAll(viewState.result)
                    binding.containerSwipeRefresh.isRefreshing = false
                }
            }
        }
    }
}