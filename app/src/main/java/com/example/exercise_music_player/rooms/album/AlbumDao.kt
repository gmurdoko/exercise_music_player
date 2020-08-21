package com.example.exercise_music_player.rooms.album

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface AlbumDao {

    @Transaction

    @Query("SELECT * FROM Album")
    fun getAlbumSongs(): LiveData<List<AlbumSongs>>

    @Query("SELECT * FROM Album")
    fun getAllAlbum(): LiveData<List<Album>>

    @Query("SELECT * FROM Album WHERE album_id = :id")
    fun getAlbumById(id:Int): LiveData<Album>

    @Insert
    fun createNewAlbum(album: Album)

    @Query(value = "SELECT * FROM Song WHERE song_album_id = :id")
    fun getSongByAlbumId(id:Int): LiveData<List<Song>>

    @Insert
    fun createNewSong(song: Song)



}