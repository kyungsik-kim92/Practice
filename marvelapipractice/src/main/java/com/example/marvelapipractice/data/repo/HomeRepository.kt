package com.example.marvelapipractice.data.repo

import com.example.marvelapipractice.network.response.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface HomeRepository {


    @GET
    suspend fun getAllCharacters(
        @Url url:String,
//
    ): Response<Character>
}