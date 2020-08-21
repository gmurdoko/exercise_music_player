package com.example.exercise_music_player.rooms.album

import androidx.lifecycle.LiveData

class AlbumRepository (private val albumDao: AlbumDao) {

    val allAlbum: LiveData<List<Album>> = albumDao.getAllAlbum()

    fun getAlbumSongs() = albumDao.getAlbumSongs()

    fun getAlbumById(id: Int) = albumDao.getAlbumById(id)

    fun createNewAlbum(album: Album) = albumDao.createNewAlbum(album)

    fun getSongByAlbumId(id: Int) = albumDao.getSongByAlbumId(id)

    fun createNewSong(song: Song) = albumDao.createNewSong(song)
}