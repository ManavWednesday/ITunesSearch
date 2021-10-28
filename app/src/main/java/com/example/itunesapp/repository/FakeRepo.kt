package com.example.itunesapp.repository

import com.example.itunesapp.model.RemoteDataModel
import com.example.itunesapp.model.RemoteSongDescription

class FakeRepo:RepositoryInter {

    private var songArrayList = arrayListOf<RemoteDataModel>()

    private val songDescription = arrayListOf<RemoteSongDescription>()

    override suspend fun search(name: String): ArrayList<RemoteDataModel> {
        return if (name == ""){
            songArrayList
        } else{
            songArrayList.add(RemoteDataModel())
            songArrayList
        }
    }

    override suspend fun searchSongDescription(
        trackId: Int,
        kind: String
    ): ArrayList<RemoteSongDescription> {
        return songDescription
    }
}