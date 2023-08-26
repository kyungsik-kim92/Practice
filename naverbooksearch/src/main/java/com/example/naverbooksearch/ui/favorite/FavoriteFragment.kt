package com.example.naverbooksearch.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.naverbooksearch.R
import com.example.naverbooksearch.adapter.FavoriteAdapter
import com.example.naverbooksearch.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteBinding
    private val favoriteViewModel : FavoriteViewModel by viewModels(
//        factoryProducer = {FavoriteViewModelProviderFactory()}

    )
    private val favoriteAdapter = FavoriteAdapter()


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


        binding.rvFavoriteBooks.adapter = favoriteAdapter

        favoriteViewModel.favoriteBooks.observe(viewLifecycleOwner){
            favoriteAdapter.addAll(it)
        }

    }
}