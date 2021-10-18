package com.example.itunesapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itunesapp.model.RemoteDataModel
import com.example.itunesapp.model.ResultDatabase
import com.example.itunesapp.repository.Repository
import com.example.itunesapp.repository.RepositoryInter
import kotlinx.coroutines.launch

class ItunesViewModel (private val repository: Repository): ViewModel() {

    var searchSongsList:MutableLiveData<ArrayList<RemoteDataModel>> = MutableLiveData()


//    suspend fun searchItem(name:String){
//        viewModelScope.launch {
//            searchSongsList.value =repository.searchItem(name)
//        }
//    }

    suspend fun search(name: CharSequence?) {
        viewModelScope.launch {
            searchSongsList.value = repository.search(name as String)
        }
    }
}