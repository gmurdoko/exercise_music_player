package com.example.exercise_music_player.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.exercise_music_player.R
import com.example.exercise_music_player.model.SongViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_song_detail.*


class SongDetailFragment : Fragment() {
    val songViewModel by activityViewModels<SongViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_song_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val position = arguments?.getInt("position") ?:0
        songViewModel.getSongs().observe(viewLifecycleOwner, Observer {
            artist_song_detail.text = it[position].artist
            title_song_detail.text = it[position].title
            Picasso.get().load(it[position].imageUrl).into(image_song_detail)
        })
    }

}