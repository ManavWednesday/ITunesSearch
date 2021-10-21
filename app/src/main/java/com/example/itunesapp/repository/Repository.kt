package com.example.itunesapp.repository

import android.util.Log
import com.example.itunesapp.database.SongDescriptionImpl
import com.example.itunesapp.model.RemoteDataModel
import com.example.itunesapp.model.RemoteSongDescription
import com.example.itunesapp.network.SearchItunesApi

class Repository(
    private val searchItunesApi: SearchItunesApi,
    private val songDescriptionDatabase: SongDescriptionImpl
) {
    suspend fun search(name: String): ArrayList<RemoteDataModel>? {
        val apiResponse = searchItunesApi.searchSongs(name)
        return apiResponse.body()?.results
    }

    suspend fun searchSongDescription(trackId:Int,kind:String):ArrayList<RemoteSongDescription>?{
        return if (songDescriptionDatabase.songDescriptionDao().checkSong(trackId)){
            Log.d("Database has song!!!!!!",arrayListOf(songDescriptionDatabase.songDescriptionDao().getSongDescription(trackId)).toString())
            arrayListOf(songDescriptionDatabase.songDescriptionDao().getSongDescription(trackId))
        } else{
            val apiResponse = searchItunesApi.getTrackData(trackId,kind)
            apiResponse.body()?.let { songDescriptionDatabase.songDescriptionDao().addSong(it.results) }
            Log.d("Database@@@@@",songDescriptionDatabase.songDescriptionDao().getAll().toString())
            Log.d("Repository@@@@@@",apiResponse.body()?.results.toString())
            apiResponse.body()?.results
        }
    }
}