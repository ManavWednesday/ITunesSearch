package com.example.itunesapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.itunesapp.model.RemoteSongDescription

@Database(entities = [RemoteSongDescription::class],version = 1)
abstract class SongDescriptionImpl : RoomDatabase() {
    abstract fun songDescriptionDao() : SongDescriptionDao
}