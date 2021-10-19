package com.example.itunesapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itunesapp.model.RemoteDataModel
import com.example.itunesapp.repository.Repository
import kotlinx.coroutines.launch

class ItunesViewModel (private val repository: Repository): ViewModel() {

    var searchSongsList:MutableLiveData<ArrayList<RemoteDataModel>> = MutableLiveData()

    fun search(name: CharSequence?) {
        viewModelScope.launch {
            searchSongsList.value = repository.search(name as String)
        }
    }
}