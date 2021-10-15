package com.example.itunesapp.repository

interface RepositoryInter {
    suspend fun searchItem(s: String)
}