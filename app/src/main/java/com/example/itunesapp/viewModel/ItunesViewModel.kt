package com.example.itunesapp.viewModel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.itunesapp.database.DatabaseImpl
import com.example.itunesapp.model.ResultDatabase
import com.example.itunesapp.network.ApiInstance
import com.example.itunesapp.repositoryMapping.ResultMappingImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ItunesViewModel(application: Application) : AndroidViewModel(application) {


    val searchItunesApi = ApiInstance.searchItunesApi

    var databaseImpl:DatabaseImpl = DatabaseImpl.getDatabase(application)

    val resultMappingImpl = ResultMappingImpl()


    fun searchItem(){

        GlobalScope.launch {
            val result = searchItunesApi.searchSongs("#search")
            if (result != null){
                var searchItem = result.body()
                if (searchItem != null) {

                    var searchList:List<ResultDatabase> = resultMappingImpl.searchList(searchItem.results)
                    Log.d("View Model@@@@@@@@@@",searchList.toString())
                    databaseImpl.databaseDao().addSearchItems(searchList)
                }


            }
        }



    }

}