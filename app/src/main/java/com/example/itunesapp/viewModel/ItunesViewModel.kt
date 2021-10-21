package com.example.itunesapp.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itunesapp.model.RemoteDataModel
import com.example.itunesapp.model.RemoteSongDescription
import com.example.itunesapp.repository.Repository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@FlowPreview
class ItunesViewModel (private val repository: Repository): ViewModel() {

    var searchSongsList:MutableLiveData<ArrayList<RemoteDataModel>> = MutableLiveData()
    var searchSongDescription:MutableLiveData<ArrayList<RemoteSongDescription>> = MutableLiveData()
    private val mutableStateFlow:MutableStateFlow<String> = MutableStateFlow("")

    init {
        viewModelScope.launch {
             mutableStateFlow
                 .map { it.trim() }
                 .debounce(300)
                 .collect {
                 if (it.isNotBlank()){
                     searchSongsList.value = repository.search(it)
                 }
             }
        }
    }
    fun search(name: String) {
        mutableStateFlow.value = name
    }

    fun searchSongDescription(trackId:Int,kind:String){
        viewModelScope.launch {
            searchSongDescription.value = repository.searchSongDescription(trackId,kind)
            Log.d("viewModel###",searchSongDescription.value.toString())
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