package com.example.itunesapp.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itunesapp.model.RemoteDataModel
import com.example.itunesapp.repository.Repository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class ItunesViewModel (private val repository: Repository): ViewModel() {

    var searchSongsList:MutableLiveData<ArrayList<RemoteDataModel>> = MutableLiveData()
    lateinit var mRemoteDataModel:RemoteDataModel

    fun shareSong(remoteDataModel: RemoteDataModel){
        mRemoteDataModel = remoteDataModel
        Log.d("@@@@@@@@@@@@@@@@@",mRemoteDataModel.toString())
    }

    fun search(name: String) {
        viewModelScope.launch {
            searchSongsList.value = repository.search(name)
        }
    }

//    fun searchXyz():StateFlow<String>{
//        val mutableStateFlow = MutableStateFlow("")
//
//
//    }
//
//    fun xyz(name:String): Flow<String> {
//        return flow {
//            delay(1000)
//            emit(name)
//        }
//    }
}