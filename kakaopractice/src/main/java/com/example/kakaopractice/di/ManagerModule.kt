package com.example.kakaopractice.di

import com.example.kakaopractice.ui.search.SearchManager
import com.example.kakaopractice.ui.search.SearchManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ManagerModule {

    @Binds
    abstract fun bindSearchManager(
        searchManagerImpl: SearchManagerImpl
    ): SearchManager

}