package com.example.exercise_music_player.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise_music_player.R
import com.example.exercise_music_player.model.AlbumViewModel
import com.example.exercise_music_player.recycleview.AlbumRecycleAdapter
import kotlinx.android.synthetic.main.fragment_album_list.*


class AlbumListFragment : Fragment(),View.OnClickListener {
    private val albumViewModel by activityViewModels<AlbumViewModel>()
    private lateinit var albumRecycleAdapter: AlbumRecycleAdapter
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        song_list_recycle_view.layoutManager = LinearLayoutManager(activity)
        albumViewModel.allAlbum.observe(viewLifecycleOwner, Observer {
            song_list_recycle_view.adapter = AlbumRecycleAdapter(it,activity)
        })

        button_add_album.setOnClickListener(this)
        navController= Navigation.findNavController(view)

    }

    override fun onClick(v: View?) {
        when(v){
            button_add_album -> {navController.navigate(R.id.action_songListFragment_to_addSongFragment)}
        }
    }


}