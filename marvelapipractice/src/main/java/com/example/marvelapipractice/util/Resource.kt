package com.example.marvelapipractice.util

sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val exception: Throwable? = null) : Resource<Nothing>()
}