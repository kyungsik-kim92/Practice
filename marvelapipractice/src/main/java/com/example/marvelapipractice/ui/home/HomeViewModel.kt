package com.example.marvelapipractice.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapipractice.data.repo.MarvelRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class HomeViewModel(private val marvelRepository: MarvelRepository) : ViewModel() {


    private val _homeViewStateLiveData = MutableLiveData<HomeViewState>()
    val homeViewStateLiveData: LiveData<HomeViewState> = _homeViewStateLiveData

    init {
        getCharacter()
    }

    private fun getCharacter(offset: Int = INIT_OFFSET, limit: Int = LIMIT_COUNT) {
        viewModelScope.launch(IO) {

            val characters = marvelRepository.getCharacters(offset = offset, limit = limit)
            if (characters.isSuccessful) {
                characters.body()?.let {
                    onChangedHomeViewState(HomeViewState.GetData(it.data.results))
                } ?: onChangedHomeViewState(HomeViewState.ShowToast("실패"))
            } else {
                onChangedHomeViewState(HomeViewState.ShowToast("실패"))
            }
        }
    }

    private fun onChangedHomeViewState(viewState: HomeViewState) = viewModelScope.launch {
        _homeViewStateLiveData.value = viewState
    }


    companion object {
        private const val INIT_OFFSET = 0
        private const val LIMIT_COUNT = 20
    }
}





