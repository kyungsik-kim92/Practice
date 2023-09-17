package com.example.marvelapipractice.network

import com.example.marvelapipractice.constants.Constants
import com.example.marvelapipractice.network.response.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {

    @GET("v1/public/characters")
    suspend fun getCharacters(
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String =  Constants.hash(),
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<Character>
}