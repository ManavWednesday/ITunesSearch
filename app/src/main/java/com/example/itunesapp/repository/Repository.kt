package com.example.itunesapp.repository

import android.content.Context
import android.util.Log
import com.example.itunesapp.database.DatabaseImpl
import com.example.itunesapp.mapper.ResultMappingImpl
import com.example.itunesapp.model.ResultDatabase
import com.example.itunesapp.network.SearchItunesApi

class Repository(
    private val searchItunesApi: SearchItunesApi,
    private val databaseImpl: DatabaseImpl,
    private val applicationContext: Context
): RepositoryInter {



    //val databaseImpl: DatabaseImpl = DatabaseImpl.getDatabase(application)

    private val resultMappingImpl = ResultMappingImpl()


    override suspend fun searchItem(s: String) {


            val result = searchItunesApi.searchSongs(s)
            val searchItem = result.body()
            if (searchItem != null) {

                val searchList:List<ResultDatabase> = resultMappingImpl.searchList(searchItem.remoteDataModels)
                Log.d("View Model@@@@@@@@@@",searchList.toString())
                databaseImpl.databaseDao().nukeTable()
                databaseImpl.databaseDao().addSearchItems(searchList)
                Log.d("RESULT &&&& " , databaseImpl.databaseDao().getAll().toString())
            }
    }
}