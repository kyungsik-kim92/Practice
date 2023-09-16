package com.example.marvelapipractice.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapipractice.data.repo.MarvelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val marvelRepository: MarvelRepository) :
    ViewModel() {

    private val _homeViewStateLiveData = MutableLiveData<HomeViewState>()
    val homeViewStateLiveData: LiveData<HomeViewState> = _homeViewStateLiveData

    private var offsetCount = INIT_OFFSET

    private var isStartSearch = AtomicBoolean(false)

    val isScrollBottomPosition: Function1<Boolean, Unit> = { isBottom ->
        if(isBottom && !isStartSearch.get()) {
            isStartSearch.set(true)
            getCharacter()
        }
    }

    init {
        getCharacter()
    }

    private fun getCharacter(
        isRefresh: Boolean = false,
        offset: Int = offsetCount,
        limit: Int = LIMIT_COUNT
    ) {
        viewModelScope.launch(IO) {
            val characters = marvelRepository.getCharacters(offset = offset, limit = limit)
            if (characters.isSuccessful) {
                characters.body()?.let {
                    if (isRefresh) onChangedHomeViewState(HomeViewState.Refresh(it.data.results))
                    else {
                        offsetCount += it.data.count
                        onChangedHomeViewState(HomeViewState.GetData(it.data.results))
                    }
                } ?: onChangedHomeViewState(HomeViewState.ShowToast("실패"))
            } else {
                onChangedHomeViewState(HomeViewState.ShowToast("실패"))
            }
            isStartSearch.set(false)
        }

    }

    fun refresh() {
        offsetCount = INIT_OFFSET
        getCharacter(isRefresh = true)
    }

    private fun onChangedHomeViewState(viewState: HomeViewState) = viewModelScope.launch {
        _homeViewStateLiveData.value = viewState
    }


    companion object {
        private const val INIT_OFFSET = 0
        private const val LIMIT_COUNT = 20
    }
}





