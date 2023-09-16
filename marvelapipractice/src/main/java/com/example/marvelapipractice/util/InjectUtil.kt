package com.example.marvelapipractice.util

import com.example.marvelapipractice.data.repo.MarvelRepository
import com.example.marvelapipractice.data.repo.MarvelRepositoryImpl

object InjectUtil {

    fun provideHomeRepository(): MarvelRepository =
        MarvelRepositoryImpl.getInstance()

}