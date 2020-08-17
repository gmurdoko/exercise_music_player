package com.example.exercise_music_player.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise_music_player.R
import com.example.exercise_music_player.SongRecycleAdapter
import com.example.exercise_music_player.model.SongViewModel
import kotlinx.android.synthetic.main.fragment_song_list.*


class SongListFragment : Fragment() {
    private val songViewModel by activityViewModels<SongViewModel>()
//    lateinit var songRecycleAdapter: SongRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_song_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        song_list_recycle_view.layoutManager = LinearLayoutManager(activity)
        songViewModel.getSongs().observe(viewLifecycleOwner, Observer {
            song_list_recycle_view.adapter = SongRecycleAdapter(it,activity)
        })

        button_add_song.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_songListFragment_to_addSongFragment)

        }

    }


}