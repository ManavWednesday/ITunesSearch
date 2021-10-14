package com.example.itunesapp.model

data class SearchItem(
    var resultCount: Int = 0,
    var results: List<Result> = listOf()
)