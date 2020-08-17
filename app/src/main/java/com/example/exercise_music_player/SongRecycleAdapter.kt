package com.example.exercise_music_player

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_music_player.model.Song
import com.squareup.picasso.Picasso

class SongRecycleAdapter(val songList: List<Song>, val getActivity: FragmentActivity?
): RecyclerView.Adapter<SongViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.song_item_layout, parent, false)
        return SongViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.albumName.text = songList[position].title
        holder.artistName.text = songList[position].artist
        Picasso.get().load(songList[position].imageUrl).into(holder.imageView)
        val bundle = bundleOf(Pair("position", position))
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_songListFragment_to_songDetailFragment,bundle)

        }
    }

}

class SongViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val albumName = v.findViewById<TextView>(R.id.song_title_list)
    val artistName = v.findViewById<TextView>(R.id.artist_song_list)
    val imageView: ImageView = v.findViewById(R.id.image_song_list)
}