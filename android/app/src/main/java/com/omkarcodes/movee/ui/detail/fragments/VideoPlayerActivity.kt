package com.omkarcodes.movee.ui.detail.fragments

import android.os.Bundle
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.omkarcodes.movee.R
import com.omkarcodes.movee.comman.Constants
import com.omkarcodes.movee.databinding.FragmentVideoPlayerBinding
import com.omkarcodes.movee.ui.detail.adapters.VideoAdapter
import com.omkarcodes.movee.ui.detail.models.video.Result
import timber.log.Timber

class VideoPlayerActivity : YouTubeBaseActivity(){
    private var _binding: FragmentVideoPlayerBinding? = null
    private val binding: FragmentVideoPlayerBinding
        get() = _binding!!
    private var yp: YouTubePlayer? = null

    override fun onCreate(p0: Bundle?) {
        super.onCreate(p0)
        setTheme(R.style.Theme_Movee)
        _binding = FragmentVideoPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

        val list = intent.getParcelableArrayListExtra<Result>(Constants.TRAILER_LIST)

        binding.apply {
            list?.let { data ->
                rvVideos.adapter = VideoAdapter(data,object : VideoAdapter.OnClickListener {
                    override fun onClick(id: String) {
                        yp?.loadVideo(id)
                        yp?.play()
                    }
                })
                ytPlayer.initialize(
                    Constants.YT_API_KEY,
                    object : YouTubePlayer.OnInitializedListener {
                        override fun onInitializationSuccess(
                            p0: YouTubePlayer.Provider?,
                            player: YouTubePlayer?,
                            p2: Boolean
                        ) {
                            yp = player
                            if (list.isNotEmpty()){
                                yp?.loadVideo(data.first().key)
                                yp?.play()
                            }
                        }

                        override fun onInitializationFailure(
                            p0: YouTubePlayer.Provider?,
                            p1: YouTubeInitializationResult?
                        ) {
                            Timber.tag("yt-error").d(p1?.name)
                        }
                    }
                )
            }
        }
    }
}