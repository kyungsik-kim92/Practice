package com.example.kakaopractice.search

import androidx.fragment.app.viewModels
import com.example.kakaopractice.R
import com.example.kakaopractice.adapter.SearchBookAdapter
import com.example.kakaopractice.base.BaseFragment
import com.example.kakaopractice.base.ViewState
import com.example.kakaopractice.databinding.FragmentSearchBinding


class SearchFragment : BaseFragment<FragmentSearchBinding,ViewState>(R.layout.fragment_search) {

    private val viewModel: SearchViewModel by viewModels()
   private lateinit var searchBookAdapter : SearchBookAdapter



    override fun initUi() {
        searchBookAdapter = SearchBookAdapter()
        binding.rvSearchResult.adapter = searchBookAdapter

        binding.btnSearch.setOnClickListener {
            viewModel.searchBooks(binding.etSearch.text.toString())

        }
        viewModel.searchResultLiveData.observe(viewLifecycleOwner) {
            searchBookAdapter.addAll(it)
        }
    }



//    override fun onChangedViewState(viewState: ViewState) {
//
//    }
}