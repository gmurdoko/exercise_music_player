package com.example.exercise_music_player.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_music_player.R
import com.example.exercise_music_player.rooms.album.Album
import com.squareup.picasso.Picasso

class AlbumRecycleAdapter(
    val songList: List<Album>,
    val getActivity: FragmentActivity?
): RecyclerView.Adapter<AlbumViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.album_item_layout, parent, false)
        return AlbumViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.albumName.text = songList[position].album_title
        holder.artistName.text = songList[position].artist
        Picasso.get().load(songList[position].image_url).into(holder.imageView)
        val bundle = bundleOf(Pair("position", position))
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_songListFragment_to_songDetailFragment,bundle)

        }
    }

}

class AlbumViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val albumName = v.findViewById<TextView>(R.id.album_title_list)
    val artistName = v.findViewById<TextView>(R.id.artist_song_list)
    val imageView: ImageView = v.findViewById(R.id.image_song_list)
}