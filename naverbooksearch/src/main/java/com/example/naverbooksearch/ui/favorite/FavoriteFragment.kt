package com.example.naverbooksearch.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.naverbooksearch.R
import com.example.naverbooksearch.adapter.BookmarkAdapter
import com.example.naverbooksearch.databinding.FragmentFavoriteBinding
import com.example.naverbooksearch.util.FavoriteViewModelFactory
import com.example.naverbooksearch.util.InjectUtil

class FavoriteFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteBinding


    private val favoriteViewModel: FavoriteViewModel by viewModels(
        factoryProducer = {
            FavoriteViewModelFactory(InjectUtil.provideFavoriteBookRepository(requireContext()))
        }
    )
    private val bookmarkAdapter = BookmarkAdapter(
        onDelete = {
            favoriteViewModel.deleteBook(it)
        }
    )

    override fun onResume() {
        super.onResume()
        favoriteViewModel.getFavoriteBooks()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvFavoriteBooks.adapter = bookmarkAdapter
        favoriteViewModel.favoriteBooks.observe(viewLifecycleOwner) {
            bookmarkAdapter.addAll(it)
        }
    }
}