package com.masai.pagingnetworkand03.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkHelper {

    private fun getNetworkInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient().newBuilder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
            .build()
    }

    fun getApiService(): ApiService = getNetworkInstance().create(ApiService::class.java)
}