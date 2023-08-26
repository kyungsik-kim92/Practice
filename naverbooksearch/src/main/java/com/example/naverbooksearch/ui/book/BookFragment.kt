package com.example.naverbooksearch.ui.book

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.naverbooksearch.databinding.FragmentBookBinding
import com.example.naverbooksearch.ui.favorite.FavoriteViewModel
import com.example.naverbooksearch.ui.favorite.FavoriteViewModelProviderFactory
import com.example.naverbooksearch.ui.search.SearchViewModel
import com.google.android.material.snackbar.Snackbar
import kotlin.system.exitProcess


class BookFragment : Fragment() {

    lateinit var binding: FragmentBookBinding

    private val args by navArgs<BookFragmentArgs>()

    private val favoriteViewModel : FavoriteViewModel by viewModels(
        factoryProducer = {FavoriteViewModelProviderFactory()}
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val item = args.item

        binding.webview.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl(item.link)

        }
            requireActivity().onBackPressedDispatcher.addCallback(
                viewLifecycleOwner, WebViewOnBackPressedCallback(binding.webview)
            )

        binding.fabFavorite.setOnClickListener{
            favoriteViewModel.saveBook(item)
            Snackbar.make(view,"Book has saved", Snackbar.LENGTH_SHORT).show()
        }


    }


    override fun onPause() {
        binding.webview.onPause()
        super.onPause()
    }

    override fun onResume() {
        binding.webview.onResume()
        super.onResume()
    }


    class WebViewOnBackPressedCallback(private val webView: WebView) :
        OnBackPressedCallback(webView.isEnabled) {
        override fun handleOnBackPressed() {
            if(webView.canGoBack()){

                webView.goBack()
            }
            else{
                exitProcess(0)
            }
        }


    }
}