package com.example.itunesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.itunesapp.R
import com.example.itunesapp.model.ResultDatabase

class SearchAdapter(private val songList: ArrayList<ResultDatabase>) :RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val songName:TextView = itemView.findViewById(R.id.songName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.songName.text = songList[position].collectionName
    }

    override fun getItemCount(): Int {
        return songList.size
    }

}