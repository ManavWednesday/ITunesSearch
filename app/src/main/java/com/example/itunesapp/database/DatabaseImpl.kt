package com.example.itunesapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.itunesapp.model.ResultDatabase

@Database(entities = [ResultDatabase::class],version = 1)
abstract class DatabaseImpl: RoomDatabase() {
    abstract fun databaseDao() : DatabaseDao

    companion object{
        @Volatile
        private var INSTANCE: DatabaseImpl? = null

        fun getDatabase(context: Context): DatabaseImpl {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        DatabaseImpl::class.java,
                        "search_items")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}