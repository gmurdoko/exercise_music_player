package com.example.exercise_music_player.rooms.album

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
class Album(
    @PrimaryKey(autoGenerate = true) val album_id : Int = 0,
    val album_title: String,
    val artist : String,
    val image_url : String
)

@Entity
class Song(
    @PrimaryKey(autoGenerate = true) val song_id : Int = 0,
    val song_album_id: Int,
    val song_name: String,
    val song_duration: String
)

data class AlbumSongs(
    @Embedded val album: Album,
    @Relation(
        parentColumn ="album_id",
        entityColumn = "song_album_id"
    )
    val song: Song
)