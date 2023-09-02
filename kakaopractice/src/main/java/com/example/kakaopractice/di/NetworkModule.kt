package com.example.kakaopractice.di

import com.example.kakaopractice.constants.KakaoConstants
import com.example.kakaopractice.network.BookApiService
import com.example.kakaopractice.room.BookSearchDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =

        Retrofit.Builder()
            .baseUrl(KakaoConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    fun provideBookApiService(retrofit: Retrofit): BookApiService =
        retrofit.create(BookApiService::class.java)




}

