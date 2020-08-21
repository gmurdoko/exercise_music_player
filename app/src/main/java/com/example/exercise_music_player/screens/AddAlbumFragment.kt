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
import com.example.exercise_music_player.rooms.album.Album
import kotlinx.android.synthetic.main.fragment_add_album.*


class AddAlbumFragment : Fragment(), View.OnClickListener {
    private val albumViewModel by activityViewModels<AlbumViewModel>()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_album, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        buttonSubmitSong.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v){
            buttonSubmitSong->{
                val albumTitle = input_album_title.text.toString()
                val artistName = input_artist_name.text.toString()
                val albumImage = input_image_url.text.toString()
                albumViewModel.createNewAlbum(Album(album_title = albumTitle, artist = artistName, image_url = albumImage ))
                Toast.makeText(v?.context,"SUCCESS: Add Album", Toast.LENGTH_SHORT).show()
                navController.navigate(R.id.action_addSongFragment_pop)
            }

        }
    }


}