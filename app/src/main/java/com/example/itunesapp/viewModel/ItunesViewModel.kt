package com.example.itunesapp.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itunesapp.database.DatabaseImpl
import com.example.itunesapp.model.ResultDatabase
import com.example.itunesapp.network.ApiInstance
import com.example.itunesapp.mapper.ResultMappingImpl
import com.example.itunesapp.repository.Repository
import kotlinx.coroutines.launch

class ItunesViewModel (private val repository: Repository): ViewModel() {


    init {
        viewModelScope.launch {
            repository.searchItem("#search")
        }
    }

}