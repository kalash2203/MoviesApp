package com.example.android.repository

import com.example.android.api.ApiService
import com.example.android.models.MoviesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getPosts():Flow<MoviesResponse> = flow {
        val response = apiService.getBreakingNews()
        emit(response)
    }.flowOn(Dispatchers.IO)

}