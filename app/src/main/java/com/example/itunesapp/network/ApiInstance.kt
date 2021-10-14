package com.example.itunesapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiInstance {

    private const val BASE_URL = "https://itunes.apple.com"

    private fun apiInstance():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    val searchItunesApi:SearchItunesApi by lazy {
        apiInstance().create(SearchItunesApi::class.java)
    }

}