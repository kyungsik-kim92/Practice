package com.example.naverbooksearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.naverbooksearch.adapter.SearchBookAdapter
import com.example.naverbooksearch.databinding.FragmentSearchBinding
import com.example.naverbooksearch.viewmodel.SearchBookViewModel

class SearchFragment: Fragment() {

    lateinit var binding : FragmentSearchBinding
    private val searchBookAdapter = SearchBookAdapter()

    private val viewModel by activityViewModels<SearchBookViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvSearchResult.adapter = searchBookAdapter


        binding.btnSearch.setOnClickListener {
            viewModel.searchBooks(binding.etSearch.text.toString())

        }



        viewModel.searchResultLiveData.observe(viewLifecycleOwner) {
            searchBookAdapter.addAll(it)
        }

        searchBookAdapter.setOnItemClickListener {
            val action = SearchFragmentDirections.actionFragmentSearchToFragmentBook(it)
            findNavController().navigate(action)
        }

    }



}