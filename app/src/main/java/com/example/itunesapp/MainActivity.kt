package com.example.itunesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.itunesapp.repository.RepositoryInter
import com.example.itunesapp.viewModel.ItunesViewModel
import com.example.itunesapp.viewModel.ItunesViewModelFactory
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel:ItunesViewModel by viewModel()

        lifecycleScope.launch {
            viewModel.searchItem()
        }

    }
}