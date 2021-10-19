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

//    suspend fun searchItem(s: String) {
//        val result = searchItunesApi.searchSongs(s)
//        Log.d("888888888",result.body().toString())
//        val searchList: List<ResultDatabase> = resultMappingImpl.searchList(result.body()?.results!!)
//        Log.d("View Model@@@@@@@@@@", searchList.toString())
//        //databaseImpl.databaseDao().nukeTable()
//        //databaseImpl.databaseDao().addSearchItems(searchList)
//        //Log.d("RESULT &&&& ", databaseImpl.databaseDao().getAll().toString())
//    }

    suspend fun search(name: String): ArrayList<RemoteDataModel>? {
        val apiResponse = searchItunesApi.searchSongs(name)
        return apiResponse.body()?.results
    }
}