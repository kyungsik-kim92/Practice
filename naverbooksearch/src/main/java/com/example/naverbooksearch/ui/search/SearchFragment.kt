package com.example.naverbooksearch.ui.search

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.naverbooksearch.R
import com.example.naverbooksearch.adapter.SearchBookAdapter
import com.example.naverbooksearch.base.BaseFragment
import com.example.naverbooksearch.databinding.FragmentSearchBinding
import com.example.naverbooksearch.ui.HomeViewModel

class SearchFragment :
    BaseFragment<FragmentSearchBinding, SearchViewState>(R.layout.fragment_search) {

    override val viewModel: SearchViewModel by viewModels(
        factoryProducer = { SearchViewModelProviderFactory() }
    )

    private val homeViewModel by viewModels<HomeViewModel>(
        ownerProducer = { requireParentFragment() }
    )


    private val searchBookAdapter = SearchBookAdapter(onItemClick = {
        homeViewModel.routeBookInfo(it)
    })


    override fun initUi() {
        binding.rvSearchResult.adapter = searchBookAdapter
        binding.viewModel = this@SearchFragment.viewModel

    }

    override fun onChangedViewState(viewState: SearchViewState) {
        when (viewState) {
            is SearchViewState.GetSearchResult -> {
                searchBookAdapter.addAll(viewState.list)
            }
        }
    }


}