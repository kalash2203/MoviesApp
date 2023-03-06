package com.example.android.api

import com.example.android.models.MoviesResponse
import com.example.android.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // interface class to get popular movies
    @GET("movie/popular")
    suspend fun getBreakingNews(
        @Query("api_key")
        apiKey: String = API_KEY
    ): MoviesResponse
}