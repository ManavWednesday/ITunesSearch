package com.example.itunesapp.network

import com.example.itunesapp.model.SearchItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchItunesApi {

    @GET("/search")
    suspend fun searchSongs(@Query("term")term:String):Response<SearchItem>
}