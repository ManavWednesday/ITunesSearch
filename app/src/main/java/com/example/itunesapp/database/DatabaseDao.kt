package com.example.itunesapp.database

import androidx.room.Dao
import androidx.room.Insert
import com.example.itunesapp.model.ResultDatabase

@Dao
interface DatabaseDao {

    @Insert
    suspend fun addSearchItems(items : List<ResultDatabase>)


}