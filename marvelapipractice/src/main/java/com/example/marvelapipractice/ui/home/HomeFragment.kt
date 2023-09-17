package com.example.marvelapipractice.ui.home

import androidx.fragment.app.viewModels
import com.example.marvelapipractice.R
import com.example.marvelapipractice.base.BaseFragment
import com.example.marvelapipractice.databinding.FragmentHomeBinding
import com.example.marvelapipractice.ext.showToast
import com.example.marvelapipractice.ui.adapter.MarvelAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewState>(R.layout.fragment_home) {

    override val viewModel: HomeViewModel by viewModels()

    private val marvelAdapter = MarvelAdapter()

    override fun initUi() {
        binding.viewModel = this.viewModel
        binding.rvCharacter.adapter = marvelAdapter
    }

    override fun onChangedViewState(viewState: HomeViewState) {
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