package com.example.marvelapipractice.data.repo

import com.example.marvelapipractice.api.RetrofitInstance
import com.example.marvelapipractice.network.response.Character
import retrofit2.Response

class HomeRepositoryImpl : HomeRepository {
    override suspend fun getAllCharacters(url: String): Response<Character> {
        return RetrofitInstance.api.getAllCharacters(url)
    }




    companion object {
        private var INSTANCE: HomeRepositoryImpl? = null

        fun getInstance(): HomeRepository =
            INSTANCE ?: HomeRepositoryImpl().also { INSTANCE = it }
    }


}