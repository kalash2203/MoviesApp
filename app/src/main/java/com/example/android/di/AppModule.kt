package com.example.android.di

import com.example.android.api.ApiService
import com.example.android.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    //Retrofit Builder Class using base url and converter factory

    @Provides
    @Singleton
    fun retrofitInstance():Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun getApiService(retrofit: Retrofit):ApiService =
        retrofit.create(ApiService::class.java)
}