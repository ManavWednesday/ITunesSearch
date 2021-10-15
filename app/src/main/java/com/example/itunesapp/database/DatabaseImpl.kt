package com.example.itunesapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.itunesapp.model.ResultDatabase

@Database(entities = [ResultDatabase::class],version = 2)
abstract class DatabaseImpl: RoomDatabase() {
    abstract fun databaseDao() : DatabaseDao

}