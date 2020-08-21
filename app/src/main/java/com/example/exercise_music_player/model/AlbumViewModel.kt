package com.example.exercise_music_player.model


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exercise_music_player.rooms.AppRoomDatabase
import com.example.exercise_music_player.rooms.album.Album
import com.example.exercise_music_player.rooms.album.AlbumDao
import com.example.exercise_music_player.rooms.album.AlbumRepository
import com.example.exercise_music_player.rooms.album.Song
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlbumViewModel(application: Application) : AndroidViewModel(application){
    private val repository: AlbumRepository
    val allAlbum: LiveData<List<Album>>

    init {
        val albumDao = AppRoomDatabase.getDatabaseInstance(application).albumDao()
        repository = AlbumRepository(albumDao)
        allAlbum =repository.allAlbum

    }

    fun createNewAlbum(album: Album) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createNewAlbum(album)
        }
    }

    fun createNewSong(song: Song) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createNewSong(song)
        }
    }

    fun getAlbumById(id:Int) = repository.getAlbumById(id)
    fun getSongByAlbumId(id:Int) = repository.getSongByAlbumId(id)
}