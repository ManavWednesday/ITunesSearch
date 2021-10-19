package com.example.itunesapp.database

import androidx.room.*
import com.example.itunesapp.model.ResultDatabase

@Dao
interface DatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSearchItems(items : List<ResultDatabase>)

    @Query("DELETE FROM search_items")
    suspend fun nukeTable()

    @Query("SELECT * FROM search_items")
    suspend fun getAll():List<ResultDatabase>


}