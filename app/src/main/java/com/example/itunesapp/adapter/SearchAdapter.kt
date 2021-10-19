package com.example.itunesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.itunesapp.databinding.ListItemBinding
import com.example.itunesapp.model.RemoteDataModel

class SearchAdapter(private val songList: ArrayList<RemoteDataModel>) :RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(songList[position]){
                binding.songName.text = collectionName
            }
        }
    }

    override fun getItemCount(): Int {
        return songList.size
    }
}