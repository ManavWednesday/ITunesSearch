package com.example.itunesapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.itunesapp.model.RemoteSongDescription

@Dao
interface SongDescriptionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSong(items : List<RemoteSongDescription>)

    @Query("SELECT * FROM song_description")
    suspend fun getAll():List<RemoteSongDescription>

    @Query("SELECT * FROM song_description WHERE trackId LIKE:trackId")
    suspend fun getSongDescription(trackId:Int): RemoteSongDescription

    @Query("SELECT EXISTS(SELECT * FROM song_description WHERE trackId = :trackId)")
    suspend fun checkSong(trackId:Int):Boolean
}