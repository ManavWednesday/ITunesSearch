package com.example.itunesapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itunesapp.model.ResultDatabase
import com.example.itunesapp.repository.Repository
import com.example.itunesapp.repository.RepositoryInter
import kotlinx.coroutines.launch

class ItunesViewModel (private val repository: Repository): ViewModel() {

    lateinit var searchSongsList:MutableLiveData<ArrayList<ResultDatabase>>


    suspend fun searchItem(){
        viewModelScope.launch {
            repository.searchItem("#search")
        }
    }

    suspend fun search(name: CharSequence?) {
        viewModelScope.launch {
            searchSongsList.value = repository.search(name)
        }
    }
}