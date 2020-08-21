package com.example.exercise_music_player.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise_music_player.R
import com.example.exercise_music_player.model.AlbumViewModel
import com.example.exercise_music_player.recycleview.SongRecycleAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_album_detail.*


class AlbumDetailFragment : Fragment(), View.OnClickListener {
    val albumViewModel by activityViewModels<AlbumViewModel>()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val position = arguments?.getInt("position") ?: 0

        albumViewModel.getAlbumById(position).observe(viewLifecycleOwner, Observer {
            song_title_detail.text = it.artist
            bandName.text = it.album_title
            Picasso.get().load(it.image_url).into(image_song_detail)
        })

        listSong_recycle_view.layoutManager = LinearLayoutManager(activity)
        albumViewModel.getSongByAlbumId(position).observe(viewLifecycleOwner, Observer {
            listSong_recycle_view.adapter = SongRecycleAdapter(it)
        })

        button_add_song.setOnClickListener(this)
        navController= Navigation.findNavController(view)
    }

    override fun onClick(v: View?) {
        when(v) {
            button_add_song ->{
                val position = arguments?.getInt("position") ?: 0
                val bundle = bundleOf(Pair("posution", position))
                navController.navigate(R.id.action_songDetailFragment_to_addSongFragment2, bundle)}

        }
    }

}