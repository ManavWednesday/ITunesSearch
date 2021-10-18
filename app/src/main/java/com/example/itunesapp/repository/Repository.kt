package com.example.itunesapp.repository

import android.content.Context
import android.util.Log
import com.example.itunesapp.database.DatabaseImpl
import com.example.itunesapp.mapper.ResultMappingImpl
import com.example.itunesapp.model.ResultDatabase
import com.example.itunesapp.model.SearchItem
import com.example.itunesapp.network.SearchItunesApi
import retrofit2.Response

class Repository(
    private val searchItunesApi: SearchItunesApi,
    private val databaseImpl: DatabaseImpl,
    private val applicationContext: Context
) {



    //val databaseImpl: DatabaseImpl = DatabaseImpl.getDatabase(application)

    private val resultMappingImpl = ResultMappingImpl()

    private var searchedSongsList: ArrayList<ResultDatabase> = arrayListOf()


    suspend fun searchItem(s: String) {


            val result = searchSongs(s)
            val searchItem = result.body()
            if (searchItem != null) {

                val searchList:List<ResultDatabase> = resultMappingImpl.searchList(searchItem.remoteDataModels)
                Log.d("View Model@@@@@@@@@@",searchList.toString())
                databaseImpl.databaseDao().nukeTable()
                databaseImpl.databaseDao().addSearchItems(searchList)
                Log.d("RESULT &&&& " , databaseImpl.databaseDao().getAll().toString())
            }
    }

    private suspend fun searchSongs(term: String): Response<SearchItem> {
        return searchItunesApi.searchSongs(term)
    }

    suspend fun search(name: CharSequence?): ArrayList<ResultDatabase> {
        val allSongsList = databaseImpl.databaseDao().getAll()
        for (i in allSongsList.indices){
            if (name?.let { allSongsList[i].collectionName?.contains(it) } == true){
                searchedSongsList.add(allSongsList[i])
            }
        }

        return searchedSongsList
    }
}