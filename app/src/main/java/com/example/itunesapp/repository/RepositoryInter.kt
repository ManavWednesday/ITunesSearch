package com.example.itunesapp.repository

import com.example.itunesapp.model.RemoteDataModel
import com.example.itunesapp.model.RemoteSongDescription

interface RepositoryInter {
    suspend fun search(name: String): ArrayList<RemoteDataModel>?
    suspend fun searchSongDescription(trackId: Int, kind: String): ArrayList<RemoteSongDescription>?
}