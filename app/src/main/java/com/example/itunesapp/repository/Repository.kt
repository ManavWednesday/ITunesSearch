package com.example.itunesapp.repository

import android.content.Context
import com.example.itunesapp.database.DatabaseImpl
import com.example.itunesapp.model.RemoteDataModel
import com.example.itunesapp.network.SearchItunesApi

class Repository(
    private val searchItunesApi: SearchItunesApi,
    private val databaseImpl: DatabaseImpl,
    private val applicationContext: Context
) {
//    val databaseImpl: DatabaseImpl = DatabaseImpl.getDatabase(application)
//    private val resultMappingImpl = ResultMappingImpl()
    private var searchedSongsList: ArrayList<RemoteDataModel> = arrayListOf()

//    suspend fun searchItem(s: String) {
//        val result = searchItunesApi.searchSongs(s)
//        Log.d("888888888",result.body().toString())
//        val searchList: List<ResultDatabase> = resultMappingImpl.searchList(result.body()?.results!!)
//        Log.d("View Model@@@@@@@@@@", searchList.toString())
//        //databaseImpl.databaseDao().nukeTable()
//        //databaseImpl.databaseDao().addSearchItems(searchList)
//        //Log.d("RESULT &&&& ", databaseImpl.databaseDao().getAll().toString())
//    }

    suspend fun search(name: String): ArrayList<RemoteDataModel> {
        searchedSongsList = arrayListOf()
        val apiResponse = searchItunesApi.searchSongs(name)
        val allSongsList = apiResponse.body()?.results
        if (allSongsList != null) {
            for (i in 0 until allSongsList.size)
                    searchedSongsList.add(allSongsList[i])
        }
        return searchedSongsList
    }
}