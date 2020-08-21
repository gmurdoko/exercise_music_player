package com.example.exercise_music_player.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.exercise_music_player.R
import com.example.exercise_music_player.model.AlbumViewModel
import com.example.exercise_music_player.rooms.album.Song
import kotlinx.android.synthetic.main.fragment_add_song.*


class AddSongFragment : Fragment(), View.OnClickListener {
    private val songViewModel by activityViewModels<AlbumViewModel>()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_song, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController= Navigation.findNavController(view)
        button_submit_song.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            button_submit_song->{
                val position = arguments?.getInt("position") ?: 1
                val songTitle = input_song_title.text.toString()
                val songDuration = input_song_duration.text.toString()
                songViewModel.createNewSong(Song(song_name = songTitle, song_duration = songDuration, song_album_id = position ))
                Toast.makeText(v?.context,"SUCCESS: Add Album", Toast.LENGTH_SHORT).show()
                navController.navigate(R.id.action_addSongFragment2_pop)
            }

        }
    }


}