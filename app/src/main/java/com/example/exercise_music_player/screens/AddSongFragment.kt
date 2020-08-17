package com.example.exercise_music_player.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.exercise_music_player.R
import com.example.exercise_music_player.model.Song
import com.example.exercise_music_player.model.SongViewModel
import kotlinx.android.synthetic.main.fragment_add_song.*


class AddSongFragment : Fragment() {
    private val songViewModel by activityViewModels<SongViewModel>()

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
        super.onViewCreated(view, savedInstanceState)

        buttonSubmitSong.setOnClickListener {
            val title = inputSongTitle.text.toString()
            val artist = inputArtistName.text.toString()
            val imageUrl = inputImageUrl.text.toString()

            val song = Song(title,artist,imageUrl)
            songViewModel.addSong(song)
            Navigation.findNavController(view).navigate(R.id.action_addSongFragment_pop)
        }
    }


}