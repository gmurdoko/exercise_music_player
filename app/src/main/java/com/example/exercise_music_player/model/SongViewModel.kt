package com.example.exercise_music_player.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SongViewModel: ViewModel(){
    var songList = mutableListOf<Song>(Song("Sunflower","Post Malone Feat. Swae Lee","https://i.pinimg.com/564x/29/84/59/29845928322f28b551c9d1e9a1454558.jpg"),
        Song("Run","Joji","https://upload.wikimedia.org/wikipedia/en/a/ad/Joji_-_Run.png"))
    var songLiveData : MutableLiveData<MutableList<Song>> = MutableLiveData(songList)

    fun addSong(newSong: Song){
        songList.add(newSong)
        songLiveData.value = songList
    }
    fun getSongs() = songLiveData as MutableLiveData<List<Song>>

}