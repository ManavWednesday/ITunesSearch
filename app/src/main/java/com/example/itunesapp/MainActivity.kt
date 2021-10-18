package com.example.itunesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.itunesapp.adapter.SearchAdapter
import com.example.itunesapp.viewModel.ItunesViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    lateinit var editText:EditText
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel:ItunesViewModel by viewModel()
        lifecycleScope.launch {
            viewModel.searchItem()
        }

        editText = findViewById(R.id.searchEditText)
        recyclerView = findViewById(R.id.recyclerView)

        editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(name: CharSequence?, p1: Int, p2: Int, p3: Int) {
                lifecycleScope.launch {
                    viewModel.search(name)
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }
        })

        viewModel.searchSongsList.observe(this,{
            recyclerView.adapter = viewModel.searchSongsList.value?.let { it1 -> SearchAdapter(it1) }
            recyclerView.layoutManager = GridLayoutManager(this,1)
        })

    }
}