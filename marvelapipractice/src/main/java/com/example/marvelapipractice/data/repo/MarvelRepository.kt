package com.example.marvelapipractice.data.repo

import com.example.marvelapipractice.network.response.Character
import retrofit2.Response

interface MarvelRepository {

    suspend fun getCharacters(
        offset : Int,
        limit : Int,
    ): Response<Character>
}