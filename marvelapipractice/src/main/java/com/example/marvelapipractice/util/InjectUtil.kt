package com.example.marvelapipractice.util

import com.example.marvelapipractice.data.repo.HomeRepository
import com.example.marvelapipractice.data.repo.HomeRepositoryImpl

object InjectUtil {


    fun provideHomeRepository(): HomeRepository =
        HomeRepositoryImpl.getInstance()


}