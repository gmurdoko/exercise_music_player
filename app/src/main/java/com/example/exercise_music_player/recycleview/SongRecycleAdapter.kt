package com.example.exercise_music_player.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_music_player.R
import com.example.exercise_music_player.rooms.album.Song

class SongRecycleAdapter(private val listSong: List<Song>) :

    RecyclerView.Adapter<SongViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.song_item_layout, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.songTitle.text = listSong[position].song_name
        holder.songDuration.text = listSong[position].song_duration
        holder.playMusic.setOnClickListener {
            holder.playMusic.setImageResource(R.drawable.ic_baseline_pause_24)
        }
    }

    override fun getItemCount(): Int {
        return listSong.size
    }

}

class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val songTitle: TextView = view.findViewById<TextView>(R.id.song_title_layout)
    val songDuration: TextView = view.findViewById<TextView>(R.id.song_duration_layout)
    val playMusic: ImageView = view.findViewById<ImageView>(R.id.song_play_layout)
}