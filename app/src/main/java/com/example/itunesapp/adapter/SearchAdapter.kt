package com.example.itunesapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.itunesapp.databinding.ListItemBinding
import com.example.itunesapp.model.RemoteDataModel

class SearchAdapter(private val onClick: OnClick) :RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private var songList: ArrayList<RemoteDataModel> = arrayListOf()

    inner class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    fun updateList(updatedSongList: ArrayList<RemoteDataModel>){
        songList = updatedSongList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)

        val viewHolder = ViewHolder(binding)

        binding.listItem.setOnClickListener {
            Log.d("###",songList[viewHolder.adapterPosition].trackId.toString())
            onClick.songDescription(songList[viewHolder.adapterPosition].trackId,songList[viewHolder.adapterPosition].kind)
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =with(holder) {
                binding.songName.text = songList[position].collectionName
    }

    override fun getItemCount(): Int {
        return songList.size
    }
}