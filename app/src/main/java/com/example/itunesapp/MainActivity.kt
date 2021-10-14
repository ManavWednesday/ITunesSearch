package com.example.itunesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.itunesapp.viewModel.ItunesViewModel
import com.example.itunesapp.viewModel.ItunesViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (application as Application).repository

        val viewModel:ItunesViewModel = ViewModelProvider(this,ItunesViewModelFactory(repository)).get(ItunesViewModel::class.java)


    }
}