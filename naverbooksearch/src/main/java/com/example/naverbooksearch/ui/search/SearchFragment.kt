package com.example.naverbooksearch.ui.search

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.naverbooksearch.R
import com.example.naverbooksearch.adapter.SearchBookAdapter
import com.example.naverbooksearch.base.BaseFragment
import com.example.naverbooksearch.data.BookSearchDatabase
import com.example.naverbooksearch.data.repo.FavoriteBookRepository
import com.example.naverbooksearch.data.repo.FavoriteBookRepositoryImpl
import com.example.naverbooksearch.databinding.FragmentSearchBinding

class SearchFragment :
    BaseFragment<FragmentSearchBinding, SearchViewState>(R.layout.fragment_search) {

    private val database = BookSearchDatabase.getInstance(requireContext())
    val favoriteBookRepository = FavoriteBookRepositoryImpl(database)


    private val searchBookAdapter = SearchBookAdapter(onItemClick = {
        viewModel.routeBook(it)

    })

    override val viewModel: SearchViewModel by viewModels(
        factoryProducer = { SearchViewModelProviderFactory() }
    )



    override fun initUi() {
        binding.rvSearchResult.adapter = searchBookAdapter
        binding.viewModel = this@SearchFragment.viewModel

    }

    override fun onChangedViewState(viewState: SearchViewState) {
        when (viewState) {
            is SearchViewState.GetSearchResult -> {
                searchBookAdapter.addAll(viewState.list)
            }

            is SearchViewState.RouteBook -> {
                val action =
                    SearchFragmentDirections.actionFragmentSearchToFragmentBook(viewState.item)
                findNavController().navigate(action)
            }

        }
    }


}