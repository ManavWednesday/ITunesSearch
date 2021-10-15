package com.example.itunesapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itunesapp.repository.RepositoryInter
import kotlinx.coroutines.launch

class ItunesViewModel (private val repository: RepositoryInter): ViewModel() {


    suspend fun searchItem(){
        viewModelScope.launch {
            repository.searchItem("#search")
        }
    }
}