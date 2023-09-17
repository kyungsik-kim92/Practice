package com.example.marvelapipractice.domain.usecase

import com.example.marvelapipractice.data.repo.MarvelRepository
import com.example.marvelapipractice.exceptions.EmptyBodyException
import com.example.marvelapipractice.exceptions.NetworkFailureException
import com.example.marvelapipractice.exceptions.SearchErrorException
import com.example.marvelapipractice.network.response.DataX
import com.example.marvelapipractice.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMarvelCharacterUseCase @Inject constructor(private val marvelRepository: MarvelRepository) {

    operator fun invoke(
        offset: Int,
        limit: Int = LIMIT_COUNT
    ): Flow<Resource<DataX>> = flow<Resource<DataX>> {

        val response = marvelRepository.getCharacters(offset = offset, limit = limit)

        if (response.isSuccessful) {

            response.body()?.let {

                if (it.data.total == 0) throw SearchErrorException("검색 결과가 없습니다.")

                emit(Resource.Success(it.data))

            } ?: throw EmptyBodyException("[${response.code()}] ${response.message()}")

        } else throw NetworkFailureException("[${response.code()}] ${response.message()}")
    }.catch {
        emit(Resource.Error(it))
    }


    companion object {
        private const val LIMIT_COUNT = 20
    }
}