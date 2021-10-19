package com.example.itunesapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.itunesapp.adapter.SearchAdapter
import com.example.itunesapp.databinding.ActivityMainBinding
import com.example.itunesapp.viewModel.ItunesViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewModel:ItunesViewModel by viewModel()

        binding.searchEditText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(name: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                val flow = flow{
//                    emit(viewModel.search(name))
//                    delay(2000L)
//                }
            viewModel.search(name.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        viewModel.searchSongsList.observe(this,{
            binding.recyclerView.adapter = viewModel.searchSongsList.value?.let { it1 -> SearchAdapter(it1) }
            binding.recyclerView.layoutManager = GridLayoutManager(this,1)
        })

    }
}