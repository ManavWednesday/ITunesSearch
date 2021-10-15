package com.example.itunesapp.model

data class SearchItem(
    var resultCount: Int = 0,
    var remoteDataModels: List<RemoteDataModel> = listOf()
)